#Timeleaf 기본기능 강의

1. 텍스트 - text, utext

타임리프는 기본적으로 HTML태그의 속성에 기능을 정의해서 동작한다. HTML의 콘텐츠(content)에 데이터를 출력할 때 는 다음과 같이 <th:text>를 사용하면 된다.

text와 utext의 차이점은 html은 기본적인 문법이 <>형식의 특수문자 기반으로 정의된다. 고로 특수문자를 사용하고 싶을 경우 utext를 사용하여 escape를 처리해준다.

예제)

    <span th:text="${data}">
    <span th:utext="${data}">

