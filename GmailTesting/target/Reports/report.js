$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/demo.feature");
formatter.feature({
  "line": 1,
  "name": "Gmail Testing",
  "description": "",
  "id": "gmail-testing",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Gmail Login",
  "description": "",
  "id": "gmail-testing;gmail-login",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "url opened",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "click Login",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "enter user id and click continue",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "enter password",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "click login",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinition.url_opened()"
});
formatter.result({
  "duration": 9502765363,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition.click_Login()"
});
formatter.result({
  "duration": 3319144072,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition.enter_user_id_and_click_continue()"
});
formatter.result({
  "duration": 2313291793,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition.enter_password()"
});
formatter.result({
  "duration": 167444701,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition.click_login()"
});
formatter.result({
  "duration": 6112677328,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Gmail Close",
  "description": "",
  "id": "gmail-testing;gmail-close",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 17,
  "name": "Close browser",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinition.close_browser()"
});
formatter.result({
  "duration": 70256,
  "status": "passed"
});
});