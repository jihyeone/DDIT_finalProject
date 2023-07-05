if (typeof jQuery === "undefined") {
    throw new Error("jQuery plugins need to be before this file");
}
$(function() {
    "use strict";
    var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
    var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
        return new bootstrap.Tooltip(tooltipTriggerEl)
    })
    
    // 접속자 변동 내역
    $(document).ready(function() { 
        var options = {
            series: [{
                name: '접속자 수',
                data: [ 35, 52, 48, 49, 51, 55, 56, 70, 55,  60, 66],
            }],
                chart: {
                height: 160,
                type: 'line',
                toolbar: {
                    show: false,
                }
            },
            grid: {
                show: false,
                xaxis: {
                    lines: {
                        show: false
                    }
                },   
                yaxis: { 
                    lines: {
                        show: false
                    }
                }, 
            },
            stroke: {
                width: 4,
                curve: 'smooth',
                colors: ['var(--chart-color2)'],
            },
            xaxis: {
                type: 'datetime',
                categories: ['6/2/2023','6/3/2023','6/4/2023','6/5/2023', '6/6/2023', '6/7/2023', '6/8/2023', '6/9/2023', '6/10/2023', '6/11/2023', '6/12/2023'],
                tickAmount: 10,
                labels: {
                    formatter: function(value, timestamp, opts) {
                        return opts.dateFormatter(new Date(timestamp), 'dd MMM')
                    }
                }
            },
            fill: {
                type: 'gradient',
                gradient: {
                    shade: 'dark',
                    gradientToColors: [ "var(--chart-color3)" ],
                    shadeIntensity: 1,
                    type: 'horizontal',
                    opacityFrom: 1,
                    opacityTo: 1,
                    stops: [0, 100, 100, 100],
                },
            },
            markers: {
                size: 3,
                colors: ["#FFA41B"],
                strokeColors: "#ffffff",
                strokeWidth: 2,
                hover: {
                    size: 7,
                }
            },
            yaxis: {
                show: false,
                min: 0,
                max: 70,
            }
        };

        var chart = new ApexCharts(document.querySelector("#apex-emplyoeeAnalytics11"), options);
        chart.render();
    });  

    // 유료회원
    $(document).ready(function() {
        var options = {
            align: 'center',
            chart: {
                height: 250,
                type: 'donut',
                align: 'center',
            },
            labels: ['기본회원', '회사소속 회원'],
            dataLabels: {
                enabled: false,
            },
            legend: {
                position: 'bottom',
                horizontalAlign: 'center',
                show: true,
            },
            colors: ['var(--chart-color4)', 'var(--chart-color3)'],
            series: [selMemChartNum-comMemChartNum, comMemChartNum],
            responsive: [{
                breakpoint: 480,
                options: {
                    chart: {
                        width: 200
                    },
                    legend: {
                        position: 'bottom'
                    }
                }
            }]
        }
        var chart = new ApexCharts( document.querySelector("#apex-MainCategories11"),options);        
        chart.render();
    }); 
    
    // 매출
  $(document).ready(function() {
        var options = {
            align: 'center',
            series: salesItemCNT,
            responsive: [{
                breakpoint: 420,
                options: {
                    chart: {
                        width: 200,
                        align: 'center',
                    },
                    legend: {
                        position: 'bottom',
                        markers: {
                            fillColors:'var(--chart-color1)'
                        },
                        labels: {
                            colors: 'var(--chart-color1)'
                        },
                    }
                }
            }],
            chart: {
                height: 336,
                type: 'polarArea',
                toolbar: {
                    show: false,
                },
            },
            labels: ['Test Plan', 'Premium Plan', 'Standard Plan', 'Basic Plan' ],
            fill: {
                opacity: 1,
                colors: ['var(--chart-color1)', 'var(--chart-color2)', 'var(--chart-color3)',  'var(--chart-color5)'],
            },
            stroke: {
                width: 1,
                colors: undefined
            },
            yaxis: {
                show: false
            },
            legend: {
                position: 'bottom', // left, right, top, bottom
                horizontalAlign: 'center',  // left, right, center
            },
            plotOptions: {
                polarArea: {
                    rings: {
                        strokeWidth: 0
                    }
                }
            },
            theme: {
                monochrome: {
                enabled: true,
                shadeTo: 'light',
                shadeIntensity: 0.6
                }
            }
        };

        var chart = new ApexCharts(document.querySelector("#incomeanalytics11"), options);
        chart.render();
    }); 
    
    // 구독현황
$(document).ready(function() {
    var options = {
        chart: {
            height: 350,
            type: 'line',
            toolbar: {
                show: false,
            },
        },
        colors: ['var(--chart-color1)', 'var(--chart-color2)'],
        series: [{
            name: '월별 신규 회원',
            type: 'column',
            data: [JoinMemberJANUARY, JoinMemberFEBRUARY, JoinMemberMARCH, JoinMemberAPRIL, JoinMemberMAY, joinMemberJUNE, joinMemberJULY, joinMemberAUGUST, joinMemberSEPTEMBER, joinMemberOCTOBER, joinMemberNOVEMBER, joinMemberDECEMBER]
        }, {
            name: '월별 신규 구독',
            type: 'line',
            data: [subscribeJANUARY, subscribeFEBRUARY, subscribeMARCH, subscribeAPRIL, subscribeMAY, subscribeJUNE, subscribeJULY, subscribeAUGUST, subscribeSEPTEMBER, subscribeOCTOBER, subscribeNOVEMBER, subscribeDECEMBER]
        }],
        stroke: {
            width: [0, 4]
        },        
        // labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
        labels: ['01 Jan 2023', '02 Feb 2023', '03 Mar 2023', '04 Apr 2023', '05 May 2023', '06 Jun 2023', '07 Jul 2023', '08 Aug 2023', '09 Sep 2023', '10 Oct 2023', '11 Nov 2023', '12 Dec 2023'],
        xaxis: {
            type: 'datetime'
        },
        yaxis: [{
            title: {
                text: 'Website Blog',
            },

        }, {
            opposite: true,
            title: {
                text: 'Social Media'
            }
        }]
    }
    var chart = new ApexCharts(
        document.querySelector("#apex-chart-line-column11"),
        options
    );

    chart.render();
	});
});
    
