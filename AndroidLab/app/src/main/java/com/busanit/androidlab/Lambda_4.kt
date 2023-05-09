package com.busanit.androidlab

// 1. 람다함수 구조 {매개변수 -> 함수 본문}
// 함수 본문의 마지막 표현식(결과값) 자동 리턴

/*
fun sum(num1 : Int, num2 : Int) : Int { // 기본 함수 구조
  return num1 + num2
}

val sum = {num1 : Int, num2 : Int -> num1 + num2} // 화살표 다음 표현식의 결과값을 변수로 리턴 */

// 1-1. 람다 함수 선언과 동시에 호출

/*
fun main() {
  println("sum의 결과는 " +
    "${{num1 : Int, num2 : Int -> num1 + num2}(20, 20)} 입니다.")
}*/

// 1-2. 매개변수 없는 람다 함수 (화살표 생략 가능)
/*fun main() {
  // run { -> println("함수가 호출되었습니다. (function call ... ) ") }
  run { println("함수가 호출되었습니다. (function call ... ) ") } // 화살표 생략
}*/

// 1-3. 매개변수가 한개인 경우 it 키워드 사용 가능

/*fun main() {
//  val some = { num1 : Int -> println("num1 : $num1")}
//  some(10)

  val some : (Int) -> Unit = { println("num1 : $it")} // 매개변수 명 대신에 it 키워드 쓰기
  some(20)
}*/

// 1-4. 람다함수의 리턴(return문 사용 안됨)

/*
fun main() {
  val some = {num1 : Int, num2 : Int ->
    println("in lambda function")
    num1 * num2// 맨 마지막 줄을 리턴한다.
  }

  var result = some(10, 20)

  println(" result : $result")
}*/

// 2. 고차 함수
// 2-1. 함수 타입 이용

/*
fun sum(num1 : Int, num2 : Int) : Int { // 일반 함수
  return num1 + num2
}

// 변수의 타입과 리턴 해줄 타입을 변수명 뒤에 적어줌
val some : (Int, Int) -> Int = {num1 : Int, num2 : Int -> num1 + num2}

fun main() {
  println("두 수의 합은 ${some(10, 20)} 입니다.")
}*/

// 2-2. 타입 별칭으로 함수타입 선언

/*typealias MyFunType = (Int, Int) -> Boolean

fun main() {
  val someFun : MyFunType = {num1 : Int, num2 : Int -> num1 > num2} // 변수와 리턴 타입 적는 거 대신에 별칭 넣기
  println(someFun(10, 20))
  println(" 두 수의 합은 ${someFun(20, 20)}입니다.")
}*/

// 2-3. 매개변수 타입 생략 가능 (타입 유추가 가능할 때)

/*
typealias MyFunType = (Int, Int) -> Boolean

fun main() {
  val someFun : MyFunType = {num1, num2 -> num1 > num2} // 매개변수 타입 생략
  println(someFun(20, 10))
  println(" 두 수의 합은 ${someFun(30, 20)}입니다.")
}*/

// 2-4. 고차함수(매개변수, 리턴값에 함수를 사용) 134p

/*
fun hofFun(arg : (Int) -> Boolean) : () -> String{
  val result = if (arg(10)){
    "valid"
  } else { "invalid" }
  return {"hofFun result : $result"}
}

fun main() {
  val result = hofFun({ num -> num > 0})
  println(result())
}*/

// 3. null 안전성

/*
fun main() {

  var data : String? = null
  */
/*
  // 기존 자바에서의 방식
  val length = if(data==null) { 0 }
  else {
    data.length
  }

  println("data length : $length")*//*


  println("data length : ${data?.length ?: 0}") // null 이면 0을 반환
}*/

// 3-1. null 안전성 연산자
// ? : null 허용 연산자, 없으면 null로 값이 바뀌었을 때 오류가 난다
/*var data : String? = "Noah"
fun main() {
  data = null
}*/

// 3-2. 엘비스 연산자 ? : 엘비스 구레나룻 처럼 보여서 그런다고 (...)
// 변수가 null 일 때 실행해야 하는 구문

fun main() {
  var data : String? = "yudah"
  println("data = ${data?.length ?: -1}") // null이면 -1을 리턴

  data = null
  println("data = ${data?.length ?: -1}")
}
