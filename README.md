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

------------------
### 타임리프 - 리터럴

리터럴이란 소스 코드상에 고정된 값을 뜻한다.

문자를 항상 ''로 감싸기 귀찮을것이다. 공백이 없는경우 하나의 토큰값으로 인식하여 ''을 생략할 수 있다.

* 문자 : 'hello'
* 숫자 : 10
* 불린 : true, false
* null: null

------
### 타임리프 - 연산

타임리프 내부에서도 연산이 가능하다.

* 산술연산
    
  연산자 : +, -, %, /, =


* 비교연산: HTML 엔티티를 사용해야 하는 부분을 주의하자,

  a> (gt), < (lt), >= (ge), <= (le), ! (not), == (eq), != (neq, ne)

* 조건식: 자바의 조건식과 유사하다.

* Elvis 연산자: 조건식의 편의 버전

* No-Operation: _ 인 경우 마치 타임리프가 실행되지 않는 것 처럼 동작한다. 이것을 잘 사용하면 HTML
의 내용 그대로 활용할 수 있다. 마지막 예를 보면 데이터가 없습니다. 부분이 그대로 출력된다.

------------
### 타임리프 - 속성

타임 내부 속성 - <<th:*>> 를 사용하면 html내부 기존 속성을 대체하여 값을 적용한다. 기존 속성이 없다면 새로 생성한다.'

####속성 추가

`th:attrappend : 속성 값의 뒤에 값을 추가한다.`

`th:attprepend : 속성 값의 앞에 값을 추가한다.`

`th:classappend : class속성에 자연스럽게 추가한다.`

####Checkd 처리

Html에서는 checked속성이 있을경우 false형태이어도 checked처리가 된다.

타임리프의 Checkd속성에 false일 경우 checkd속성 자체를 제거하고 checkbox만 남겨져있다.

`th:checked="false"`
`th:checked="true"`

---------------
###타임리프 - 반복

타임리프에서는 JAVA의 Eneration, Iterable을 구현한 모든 객체의 반복을 사용할 수 있다.
Map에도 반복을 사용할 수 있는데 반복을 사용하면 변수에 담기는 값은 Map.Entry이다.

* 반복

`th:each="value : ${객체}"`

* 반복 상태 유지 = (value name) + Stat [생략 가능]


    index : 0부터 시작하는 값
    count : 1부터 시작하는 값
    size : 전체 사이즈
    even , odd : 홀수, 짝수 여부( boolean )
    first , last :처음, 마지막 여부( boolean )
    current : 현재 객체`

---------------------
###타임리프 - 조건부 평가

if, unless if