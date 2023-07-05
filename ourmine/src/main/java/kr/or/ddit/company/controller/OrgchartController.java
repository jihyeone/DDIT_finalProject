
package kr.or.ddit.company.controller;

import kr.or.ddit.company.vo.OrgchartVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.MemberVOWrapper;
import kr.or.ddit.projectAttend.vo.ProjectAttendVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import kr.or.ddit.company.service.OrgchartService;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/company/{companyId}/orgchart")
public class OrgchartController {

	private final OrgchartService service;
	private final MemberService memberService;

	@GetMapping("/orgchartList") // 조직도 jsp 보내기
	public String orgchartList(@PathVariable int companyId, Model model) {
		model.addAttribute("companyId", companyId);
		return "orgchart/orgchartList";
	}

	@GetMapping("/orgchartListJson") // 회사 전체 조직도 조회
	@ResponseBody
	public List<OrgchartVO> orgchartListJson(Authentication user) {
		MemberVOWrapper realUser = (MemberVOWrapper) user.getPrincipal();
		return service.orgchartList(realUser.getRealUser().getMemberId());
	}

	// 부서를 클릭하면 소속된 직원들이 나옴
	@PostMapping(value = "/orgchartMemberListJson", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<OrgchartVO> orgchartMemberListJson(@RequestBody OrgchartVO orgchart, @PathVariable int companyId) {
		orgchart.setCompanyId(companyId);
		List<OrgchartVO> orgchartVOS = service.orgchartMemberList(orgchart);
		log.info("orgchartVOS = {}", orgchartVOS);
		return orgchartVOS;
	}

	// 부서에 직원을 추가
	@GetMapping("/orgchartAddMemberListJson")
	@ResponseBody
	public List<OrgchartVO> orgchartAddMemberListJson(@PathVariable int companyId, Authentication user) {
		OrgchartVO orgchart = new OrgchartVO();
		MemberVOWrapper principal = (MemberVOWrapper) user.getPrincipal();
		MemberVO memberVO = memberService.memberMyPageSelect(principal.getRealUser().getMemberId());
		orgchart.setCompanyId(memberVO.getCompanyId());
		List<OrgchartVO> orgchartVOS = service.orgchartAddMemberList(orgchart);

		orgchartVOS.forEach(issue -> {
			Optional.ofNullable(issue.getMemberImageFileRoute()).filter(fileRoute -> {
				Path path = Paths.get(fileRoute);
				return Files.exists(path);
			}).ifPresent(fileRoute -> {
				try {
					String filePathName = issue.getMemberImageFileRoute();
					String fileExtName = issue.getFileExtension();
					Path path = Paths.get(fileRoute);
					byte[] fileArray = Files.readAllBytes(path);
					String encodedString = Base64.getEncoder().encodeToString(fileArray);
					String changeString = "data:image/" + fileExtName + ";base64, " + encodedString;
					log.info("changeString = {}", changeString);
					issue.setImageContents(changeString);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		});
		return orgchartVOS;
	}

	// 직원을 부서에 추가
	@PostMapping("/orgchartMember")
	@ResponseBody
	public int orgchartMember(@RequestBody List<OrgchartVO>  orgchart) {
		return service.orgchartMemberInsert(orgchart);
	}

	@PostMapping("/orgchartInsert") // 조직도 작성 완료
	@ResponseBody
	public int orgchartInsert(@RequestBody OrgchartVO orgchart, Authentication user) {
		MemberVOWrapper principal = (MemberVOWrapper) user.getPrincipal();

		MemberVO memberVO = memberService.memberMyPageSelect(principal.getRealUser().getMemberId());
		orgchart.setCompanyId(memberVO.getCompanyId());

		int mId = principal.getRealUser().getMemberId();
		MemberVO mVO = memberService.memberMyPageSelect(mId);
		orgchart.setCompanyId(mVO.getCompanyId());

		log.info("orgchart = {}", orgchart);

		return service.insertOrgchart(orgchart);
	}

	@ResponseBody
	@PostMapping(value = "/orgchartUpdate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE) // 조직도 수정 완료
	public int orgchartUpdate(@RequestBody OrgchartVO orgchart) {

		return service.updateOrgchart(orgchart);
	}

	@ResponseBody
	@PostMapping("/orgchartDelete") // 조직도 삭제하기전에 비밀번호 같은거 체크 먼저하기
	public int orgchartDelete(@RequestBody OrgchartVO orgchart, Authentication user) {
		MemberVOWrapper principal = (MemberVOWrapper) user.getPrincipal();
		int mId = principal.getRealUser().getMemberId();
		MemberVO mVO = memberService.memberMyPageSelect(mId);
		orgchart.setCompanyId(mVO.getCompanyId());
		return service.deleteOrgchart(orgchart);
	}

	@ResponseBody
	@GetMapping("/orgchartSelectMemberList")
	public List<OrgchartVO> orgchartSelectMemberList(
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "size", defaultValue = "3") int size,
			@RequestParam int orgchartId,
			@PathVariable int companyId
			) {
		OrgchartVO orgchart = new OrgchartVO();

		orgchart.setCurrentPage(page);
		orgchart.setPageSize(size);
		orgchart.setCompanyId(companyId);
		orgchart.setOrgchartId(orgchartId);
		List<OrgchartVO> OrgchartVO = service.orgchartSelectMemberList(orgchart);


		OrgchartVO.forEach(issue -> {
			Optional.ofNullable(issue.getMemberImageFileRoute()).filter(fileRoute -> {
				Path path = Paths.get(fileRoute);
				return Files.exists(path);
			}).ifPresent(fileRoute -> {
				try {
					String filePathName = issue.getMemberImageFileRoute();
					String fileExtName = issue.getFileExtension();
					Path path = Paths.get(fileRoute);
					byte[] fileArray = Files.readAllBytes(path);
					String encodedString = Base64.getEncoder().encodeToString(fileArray);
					String changeString = "data:image/" + fileExtName + ";base64, " + encodedString;
					log.info("changeString = {}", changeString);
					issue.setImageContents(changeString);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		});
		return OrgchartVO;
	}

	@ResponseBody
	@PostMapping("/orgchartSeniorList")
	public List<OrgchartVO> orgchartSeniorList(@RequestBody OrgchartVO orgchart) {
		return service.orgchartSeniorList(orgchart);
	}


	@ResponseBody
	@PostMapping("/orgchartSeniorUpdate")
	public int orgchartSeniorUpdate(@RequestBody OrgchartVO orgchart) {
		log.info("시니어 = {}",orgchart);
		return service.orgchartSeniorUpdate(orgchart);
	}


}
