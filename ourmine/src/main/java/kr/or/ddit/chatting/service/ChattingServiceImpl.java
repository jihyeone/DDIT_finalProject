package kr.or.ddit.chatting.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import kr.or.ddit.alarm.dao.AlarmDAO;
import kr.or.ddit.alarm.vo.AlarmVO;
import kr.or.ddit.chatting.dao.ChattingDAO;
import kr.or.ddit.chatting.vo.ChatVO;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.ui.AlarmSendUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChattingServiceImpl implements ChattingService {

	private final ChattingDAO chattingDAO;
	
	
	@Override
	public List<MemberVO> selectChatCoMemList(int companyId) {
		
		return chattingDAO.selectChatCoMemList(companyId);
	}

	@Override
	public List<ChatVO> selectChatList(int memId) {
		List<ChatVO> chat = chattingDAO.selectChatList(memId);
		
		
		return chat;
	}

	@Override
	public String selectLastContent(int chattingId) {

		return chattingDAO.selectLastContent(chattingId);
	}

	@Override
	@Transactional
	public int insertChatRoom(ChatVO chatVO) {
		int chatRoom = chattingDAO.insertChatRoom(chatVO);
		int memberId;
		int temp;
		memberId = chatVO.getMemberId();
		chatVO.setMemberId(memberId);
		chattingDAO.insertChatMemList(chatVO);
		
		AlarmVO alarms = new AlarmVO();
		alarms.setChattingId(chatVO.getChattingId());// 채팅방 알람
		alarms.setAlarmContent("새로운 채팅방이 개설되었습니다");// 알림 내용
		alarms.setAlarmSender(chatVO.getChattingMemName());//보낸사람 이름
		alarms.setSenderId(memberId);
		
		List<Integer> memberList = chatVO.getMemberList();
		if(chatVO.getMemberList() != null) {
//			for(int i=0; i<memberList.size(); i++) {
			for(Integer a : memberList) {
				temp = a;
				chatVO.setMemberId(temp);
				chattingDAO.insertChatMemList(chatVO);
				//알람호출
				alarms.setReceiverId(temp);// 채팅방 수신자 아이디
				String alarmReceiver = chattingDAO.selectChattingAlarmReceiver(temp);
				alarms.setAlarmReceiver(alarmReceiver);// 채팅방 수신자 이름
				chattingDAO.insertChattingAlarm(alarms);//알람테이블 생성
				
				String senderId =  String.valueOf(alarms.getSenderId());
				AlarmSendUtil.send(alarms.getAlarmSender(), senderId, alarms.getAlarmContent(), null);
				
			}
		}
		
		chatVO.setMemberId(memberId);
		log.info("chatVO:{}",chatVO);
		
		return chatRoom;
	}

	@Override
	public List<MemberVO> selectDeptList(int companyId) {
		
		return chattingDAO.selectDeptList(companyId);
	}
	@Override
	public List<MemberVO> selectTeamList(MemberVO memberVO) {
		
		List<MemberVO> list= chattingDAO.selectTeamList(memberVO);
		
		return list;
	}

	@Override
	public void insertMessage(ChatVO chatVO) {
		chattingDAO.insertMessage(chatVO);
		
		List<Integer> memberList = new ArrayList<>();
				
		List<Integer> OrigMemList = chattingDAO.selectChattingAlarmList(chatVO.getChattingId());
		for(Integer list : OrigMemList) {
			if(list != chatVO.getMemberId()) {
				memberList.add(list);
			}
		}
		log.info("memberList:{}",memberList);
		
		AlarmVO alarms = new AlarmVO();
		alarms.setChattingId(chatVO.getChattingId());// 채팅방 알람
		alarms.setAlarmContent("새로운 채팅이 도착했습니다.");// 알림 내용
		alarms.setAlarmSender(chatVO.getMemberName());//보낸사람 이름
		alarms.setSenderId(chatVO.getMemberId());
		
		if(memberList != null) {
			for(Integer a : memberList) {
				int temp = a;
				alarms.setReceiverId(temp);
				//알람호출
				String alarmReceiver = chattingDAO.selectChattingAlarmReceiver(temp);
				alarms.setAlarmReceiver(alarmReceiver);// 채팅방 수신자 이름
				chattingDAO.insertChattingAlarm(alarms);//알람테이블 생성
				
				String senderId =  String.valueOf(alarms.getSenderId());
				AlarmSendUtil.send(alarms.getAlarmSender(), senderId, alarms.getAlarmContent(), null);
			
			}
		}
	}

	@Override
	public List<ChatVO> selectChatCont(int chattingId) {
		List<ChatVO> list = chattingDAO.selectChatCont(chattingId);
		log.info("selectChatContselectChatCont:{}",list);
		
		return list;
	}

	@Override
	public List<ChatVO> selectGroupChatList(int memberId) {
		List<ChatVO> groupChat = chattingDAO.selectGroupChatList(memberId);
		log.info("groupChat:{}",groupChat);
		return groupChat;
	}

	@Override
	public ChatVO selectCheckRoom(ChatVO chatVO) {
		ChatVO selectCheckRoom = chattingDAO.selectCheckRoom(chatVO);
		return selectCheckRoom;
	}

	@Override
	public List<String> getThisChattingMemberList(int chattingId) {
		List<String> list = chattingDAO.getThisChattingMemberList(chattingId);
			
		return list;
	}

	@Override
	public int chattingRoomOut(ChatVO chatVO) {
		int cnt = chattingDAO.chattingRoomOut(chatVO);
		return cnt;
	}

	@Override
	public ChatVO chattingContentTime(ChatVO chatVO) {

		return chattingDAO.chattingContentTime(chatVO);
	}

	@Override
	public String selectSenderName(String sender) {
		
		return chattingDAO.selectSenderName(sender);
	}

	@Override
	public List<MemberVO> selectTeamMemList(MemberVO memberVO) {

		return chattingDAO.selectTeamMemList(memberVO);
	}



}
