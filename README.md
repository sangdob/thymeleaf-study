##Timeleaf 기본기능 강의

###1. 텍스트 - text, utext

타임리프는 기본적으로 HTML태그의 속성에 기능을 정의해서 동작한다. HTML의 콘텐츠(content)에 데이터를 출력할 때 는 다음과 같이 <th:text>를 사용하면 된다.

text와 utext의 차이점은 html은 기본적인 문법이 <>형식의 특수문자 기반으로 정의된다. 고로 특수문자를 사용하고 싶을 경우 utext를 사용하여 escape를 처리해준다.

예제)

    <span th:text="${data}">
    <span th:utext="${data}">

-------------------

###2. 변수 - SpringEL

타임리프에서는 변수를 사용할때에는 변수 표현식을 사용한다.

**변수표현식 ${...}**

스프링이 제공하는 변수 표현식에는 형태에 따라 직접적인 사용방법이 전부 다르다.

Object
    
    th:text = ${data.id}
    th:text = ${data.getId}
    th:text = ${data['id']}

List

    th:text = ${data[0].id}
    th:text = ${data[0].getId}
    th:text = ${data[0]['id']}

Map

    th:text = ${data['data'].id}
    th:text = ${data['data'].getId}
    th:text = ${data['data']['id']}

---------------
###3. 타임리프 - 기본객체

타임리프의 기본 객체를 설명한다

    Request = ${#request}
    Response = ${#response}
    Session = ${#session}
    ServletContext = ${#servletContext}
    Locale = ${#locale} 

타임리프의 편의 객체 설명

    request Param = ${param.paramData}
    session =  ${session.sessionData}
    bean = ${@helloBean.hello('test text')}

--------------
###4. 타임리프 - 유틸리티 객체와 날짜

타임리프에서는 문자, 숫자, 날짜, URI등 편리하게 사용할 수 있는 다양한 유틸리티 객체들을 제공한다.

    #message : 메시지, 국제화 처리
    #uris : URI 이스케이프 지원
    #dates : java.util.Date 서식 지원
    #calendars : java.util.Calendar 서식 지원
    #temporals : 자바8 날짜 서식 지원
    #numbers : 숫자 서식 지원
    #strings : 문자 관련 편의 기능
    #objects : 객체 관련 기능 제공
    #bools : boolean 관련 기능 제공
    #arrays : 배열 관련 기능 제공
    #lists , #sets , #maps : 컬렉션 관련 기능 제공
    #ids : 아이디 처리 관련 기능 제공, 뒤에서 설명

