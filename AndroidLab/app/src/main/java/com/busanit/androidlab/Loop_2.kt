package com.busanit.androidlab

// 조건문과 반복문
// 1. if ~ else

/*
fun main(){
  var data = 10
  if(data>0){
    println("data > 0")
  } else {
    println("data <= 0")
  }
}*/

// 1-1. else if
/*fun main(){
  var data = 10
  if(data>10){
    println("data > 10")
  } else if (data>0 && data <= 10){
    println("data > 0 && data <= 10")
  } else {
    println("data <= 0")
  }
}*/

// 1-2. if else 표현식(값)
/*fun main() {
  var data = 10
  val result = if (data > 0){ // 결과 값 반환(여러 줄일 때 마지막 줄 값 리턴)
    println("data > 0")
    true // 맨 마지막 값이 변수로 리턴 된다
  } else {
    println("data <= 0")
    false
  } // 표현식으로 사용할 때는 else 생략 불가능

  println("result : $result")
}*/

// 2. when 조건문, 자바에서의 switch와 비슷하다
/*
fun main() {
  var data = 30
  when(data) {
    10 -> println("data is 10") // 데이터가 10일 경우
    20 -> println("data is 20")
    else -> println("data is no valid data")
  }
}*/

// 2-1. when 조건에 String

/*fun main() {
  var data = "hello";
  when(data) {
    "hello" -> println("data is hello")
    "world" -> println("data is world")
    else -> println("data is not valid data")
  }
}*/

// 2-2. when 다양한 조건 사용
/*fun main() {
  var data : Any = 10
  when(data){
    is String -> println("data is String") // is는 데이터 타입을 확인하는 연산자
    20, 30 -> println("data is 20 or 30") // 20 또는 30 이면
    in 1 .. 10 -> println("data is 1..10") // 1에서 10 사이의 숫자가 들어왔다면
    else -> println("data is not valid data")
  }
}*/

// 2-3. when 조건 없이 사용 (조건을 아래 case에 표현)
/*
fun main() {
  var data = 10
  when{
    data <= 0 -> println("data is <= 0")
    data > 100 -> println("data > 100")
    else -> println("data is valid")
  }
}*/

// 2-4. when 표현식 사용
/*
fun main() {
  var data = 101
  val result = when{
    data <= 0 -> "data is <= 0"
    data > 100 -> "data is >100"
    else -> "data is valid"
  }

  println("result : $result")
}*/

// 3. for (범위 연산자 in 사용)
//fun main() {
//  var sum : Int = 0
//  for(i in 1 .. 10){ // 1~10
//    sum += i
//  }

//  for(i in 1 until 10){ // 1~9 until을 사용하면 같다 부등호가 없어진다
//    sum += i
//  }

//  for (i in 2..10 step 2){ // 2씩 증가하도록 함, step : 증가/감소 폭 지정
//    sum += i
//  }

//  for (i in 10 downTo 1 step 2){ // downTo : 감소시키면서 반복 , step도 같이 사용 가능
//    sum += i
//  }
//  println(sum)
//}

// 3-1. 컬렉션 크기만큼 반복 indices
/*
fun main() {
  var data = arrayOf<Int>(10, 20, 30)
  for (i in data.indices){ // indices : index의 복수형, 인덱스 0, 1, 2 순서대로 가져옴
    print(data[i])
    if (i != data.size-1) print(", ") // i가 2보다 작으면 콤마도 같이 찍어주라
  }
}*/

// 3-2. 인덱스, 데이터 함께 가져오기 withindex
/*fun main() {
  var data = arrayOf<Int>(10, 20, 30)
  for ((index, value) in data.withIndex()){
    print(value) // 가져온 value를 찍고
    if (index != data.size-1) print(", ") // index를 비교
  }
}*/

// 3-3.while문
fun main() {
  var x = 0
  var sum = 0
  while (x < 10){
    sum += ++x // 증가시킨 다음 더해라
  }

  println("sum : $sum")
}