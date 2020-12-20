<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script src="http://malsup.github.com/jquery.form.js"></script>
<link rel="stylesheet" href="https://uicdn.toast.com/grid/latest/tui-grid.css" />
<script src="https://uicdn.toast.com/grid/latest/tui-grid.js"></script>
<script type="text/javascript" src="https://uicdn.toast.com/tui.code-snippet/v1.5.0/tui-code-snippet.js"></script>
<script type="text/javascript" src="https://uicdn.toast.com/tui.pagination/v3.3.0/tui-pagination.js"></script>

<script type="text/javascript">

/***********************************************************
*
* Author : serpiko@hanmail.net 허정진 / 2017.06.09
*
* Last Update : 2018.03.05
*
* ClassName : Browser
*
* Public Method : getType, isIE, isMobile
*
 
권장하는 사용법
 
var browser = new Browser;
console.log( browser.getType() );
console.log( browser.isIE() );
console.log( browser.isMobile() );
 
*
*
*
***********************************************************/
var Browser = function () {}

Browser.prototype = (function () {
    return {
        constructor: Browser
    }
})();

Browser.prototype.getType = function () {

    var agent = navigator.userAgent.toLowerCase(),
        name = navigator.appName,
        browser;
	alert(agent);


    // MS 계열 브라우저를 구분하기 위함.
    if (name === 'Microsoft Internet Explorer' || agent.indexOf('trident') > -1 || agent.indexOf('edge/') > -1) {

        /*
        var trident = _ua.match(/Trident\/(\d.\d)/i);
        if( trident != null )
        {
        if( trident[1] == "7.0" ) return rv = "IE" + 11;
        if( trident[1] == "6.0" ) return rv = "IE" + 10;
        if( trident[1] == "5.0" ) return rv = "IE" + 9;
        if( trident[1] == "4.0" ) return rv = "IE" + 8;
        }
        */

        browser = 'ie';
        if (name === 'Microsoft Internet Explorer') { // IE old version (IE 10 or Lower)
            agent = /msie ([0-9]{1,}[\.0-9]{0,})/.exec(agent);
            browser += parseInt(agent[1]);
        } else { // IE 11+
            if (agent.indexOf('trident') > -1) { // IE 11
                browser += 11;
            } else if (agent.indexOf('edge/') > -1) { // Edge
                browser += 'edge';
            }
        }

        return browser;

    } else {
		
        //other
        if (agent.indexOf("chrome") != -1) return 'Chrome';
        if (agent.indexOf("crios") != -1) return 'Chrome';
        if (agent.indexOf("opera") != -1) return 'Opera';
        if (agent.indexOf("staroffice") != -1) return 'Star Office';
        if (agent.indexOf("webtv") != -1) return 'WebTV';
        if (agent.indexOf("beonex") != -1) return 'Beonex';
        if (agent.indexOf("chimera") != -1) return 'Chimera';
        if (agent.indexOf("netpositive") != -1) return 'NetPositive';
        if (agent.indexOf("phoenix") != -1) return 'Phoenix';
        if (agent.indexOf("firefox") != -1) return 'Firefox';
        if (agent.indexOf("safari") != -1) return 'Safari';
        if (agent.indexOf("skipstone") != -1) return 'SkipStone';
        if (agent.indexOf("netscape") != -1) return 'Netscape';
        if (agent.indexOf("mozilla/5.0") != -1) return 'Mozilla';
    }
}

Browser.prototype.isIE = function () {
    var bool = false;
    var patt = /ie/gi;
    if (patt.test(this.getType())) bool = true;
    return bool;
}

Browser.prototype.isMobile = function () {
    var filter = "win16|win32|win64|mac";
    if (navigator.platform) {
        if (filter.indexOf(navigator.platform.toLowerCase()) < 0) {
            //alert('mobile');
            return true; //Mobile
        } else {
            //alert('pc');
            return false; //PC
        }
    }
}


Browser.prototype.getVersion = function () {
	var userAgent =  navigator.userAgent.toLowerCase();
	var browser = "";
alert(userAgent)
	if(userAgent.indexOf("Trident") > -1 || userAgent.indexOf("MSIE") > -1) { //IE

		if(userAgent.indexOf("Trident/7") > -1) {
			browser = "11";
		}else if(userAgent.indexOf("Trident/6") > -1) {
			browser = "10";
		}else if(userAgent.indexOf("Trident/5") > -1) {
			browser = "9";
		}else if(userAgent.indexOf("Trident/4") > -1) {
			browser = "8";
		}else if(userAgent.indexOf("edge") > -1) {
			browser = "edge";
		}

	}else if(userAgent.indexOf("whale") > -1){ //네이버 WHALE
		browser = userAgent.split("whale/")[1].toString().split(" ")[0].toString();
	}else if(userAgent.indexOf("opera") > -1 || userAgent.indexOf("opr") > -1){ //오페라
		if(userAgent.indexOf("opera") > -1) {
			browser = userAgent.split("opera/")[1].toString().split(" ")[0].toString();
		}else if(userAgent.indexOf("opr") > -1) {
			browser = userAgent.split("opr/")[1].toString().split(" ")[0].toString();
		}
	}else if(userAgent.indexOf("firefox") > -1){ //파이어폭스
		browser = userAgent.split("firefox/")[1].toString().split(" ")[0].toString();
	}else if(userAgent.indexOf("safari") > -1 && userAgent.indexOf("chrome") == -1 ){ //사파리
		browser = userAgent.split("safari/")[1].toString().split(" ")[0].toString();
	}else if(userAgent.indexOf("chrome") > -1){ //크롬
		browser = userAgent.split("chrome/")[1].toString().split(" ")[0].toString();
	}

	return browser;
}

function getType(){
	var browser = new Browser();
	alert(browser.getType());
}

function isIe(){
	var browser = new Browser();
	alert(browser.isIE());
}

function isMobile(){
	var browser = new Browser();
	alert(browser.isMobile());
}
function getVersion(){
	var browser = new Browser();
	alert(browser.getVersion());
}


</script>

<div class="container-fluid">
	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">프로그램 현황</h1>
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">프로그램 리스트</h6>
		</div>
		<div class="card-body">
			<form class="frm" id="frm" name="frm" enctype="multipart/form-data" action="/torrent/addTorrent.do" method="post" accept-charset="UTF-8">
				<input type="file" id="file" name="file">
				<input type="hidden" id="ProcName" name="ProcName" value="torrent">
				<input type="hidden" id="subProcName" name="subProcName" value="add">
			</form>
		</div>
	</div>
	<input type="button" onclick="getProgramList()" value="테스트">
	<input type="button" onclick="getType()" value="타입">
	<input type="button" onclick="isIe()" value="IE">
	<input type="button" onclick="isMobile()" value="Mobile">
	<input type="button" onclick="getVersion()" value="Version">
	
	
</div>

<script src="/resources/js/torrent/add.js"></script>