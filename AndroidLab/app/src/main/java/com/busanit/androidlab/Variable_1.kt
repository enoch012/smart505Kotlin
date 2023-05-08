package com.busanit.androidlab

/*
* 1. 변수 선언하기
* val : 값 변경 불가 (value), var : 값 변경 가능 (variable)
* */

/*
val data1 = 10 // 코틀린에선 세미콜론 안 씀
var data2 = 10

fun main() {
  data1 = 20 // val 로 지정했기 때문에 값을 바꿀 수 없다.
  data2 = 20
}*/

/* 1.1 변수 타입 지정 */

/* val data1:Int = 10 // 생략 가능
val data2 = 10 */

/* 1-2 초기값 할당(최상위 변수, 클래스 멤버 변수는 선언과 동시에 초기값 할당) */
// val data1:Int = 10 // 초기값 할당 안 하면 에러가 뜬다

/*
class User{
  val data2 : Int = 20 //  클래스 내 멤버 변수도 초기값 지정을 안해주면 에러가 뜬다
}

fun some(){
  val data3 : Int // 일반 함수에서는 타입만 지정해줘도 에러가 안 난다
}
*/

// 초기값 입력을 안하고 싶으면 어떻게 해야 할까?
// 1-3. 초기화 미루기 (lateinit 키워드 이용)

// lateinit var data1 : Int // Int, long, short, float, double, boolean, byte 타입은 사용할 수 없다.
// lateinit var data2 : String
// lateinit val data3 : String // val은 바로 값을 할당해 줘야하기 때문에 lateinit이 고장난다

// 1-4. 초기화 미루기 (lazy 키워드 이용)

/*val data1 : Int by lazy {
  println("by lazy")
  10
}

fun main (){
  println("in main...")
  println(data1 + 10)
  println(data1 + 10)
}*/

// 2. 데이터 타입

/*fun someFun(){
  var data1 : Int = 10
  var data2 : Int? = null // Int인데 null이 들어갈 수 있게 하고 싶으면 물음표 붙이기. Int가 객체이기 때문에 넣을 수 있는 것

  data1 = data1.plus(10) // Int 객체이기 때문에 메소드를 다룰 수 있다. 코틀린은 모든 변수를 객체로 다룬다.
}*/

// 2-1. 기초 데이터 타입 객체
val a1 : Byte = 0b00001011
val a2 : Short = 123
val a3 : Long = 10L
val a4 : Double = 10.0
val a5 : Float = 10.0f
val a6 : Boolean = true // 자료형들이 다 객체로 다루어진다. lateinit 사용 불가

// 2-2. 문자와 문자열
val a : Char = 'a' // 작은따옴표 사용, 자바처럼 숫자 변환 불가
/*if(a == 1){}*/ // char 타입 데이터를 Number로 변환 불가

/*
fun main(){
  val str1 = "Hello\nWorld"
  val str2 = """ 
    Hello
    World
  """.trimIndent() // 큰 따옴표 3개는 형태를 그대로 출력해준다
  println("str1 : $str1") // 값을 찍을 때는 변수명 앞에 $를 붙여주면 된다
  println("str2 : $str2")
}*/

// 2-3. 문자열 템플릿($) 사용
/*fun main() {
  fun sum(no:Int) : Int { // sum 함수는 파라미터로 no라는 이름의 Int 값을 받고, int 값을 리턴해준다
    var sum = 0
    for (i in 1 .. no) { // 파라미터 no 값까지 반복하겠다
      sum += i
    }

    return sum;
  }

  val name : String = "kkang"
  // 함수를 사용하거나 계산식을 사용하고 싶을 땐 중괄호와 함께 앞에 $를 붙이면됨
  println("name : $name, sum : ${sum(10)}, plus : ${10 + 20} ")
}*/

// 2-4. Any 타입 - 모든 타입 지정 가능
/*val data1 : Any = 10 // Int로 인식
val data2 : Any = "hello" // String으로 인식

class User {}

val data3 : Any = User() // 클래스 객체도 넣을 수 있다. */

// 2-5. Uint 타입 - 리턴 없는 함수 (자바에서는 void)
/*val data1 : Unit = Unit
fun some2(){ // 반환 타입을 생략해도 자동으로 Unit으로 이해를 한다.
  println(20 + 30)
}

fun some() : Unit { // = void
  println(10 + 20)
}*/

// 2-6.Nothing 타입
/*
val data1 : Nothing? = null // Nothing 타입 변수에는 null 만 대입 가능
// 데이터로서의 의미 없음

fun some1() : Nothing?{
  return null;
} // 반환값이 null, 또는 예외를 던지는 함수의 리턴 타입으로 지정 가능
// 문법적으로 큰 의미를 가지지는 않음

fun some2() : Nothing? {
  throw Exception()
}*/

// 2-7. null 허용과 불허용
/*
var data1 : Int = 10
fun some(){
  data1 = null
}

var data2 : Int? = 10
fun main(){
  data2 = null
} // 데이터 타입에 물음표를 넣어줘야 null로 값 변경이 가능함

*/

// 3. 함수 선언하기(fun 키워드 사용)

//fun some(data1 : Int) : Int {
//  return data1 * 10
//} // 함수명 ( 파라미터 이름 : 데이터 타입 ) : 리턴 데이터 타입

//fun some2(data1: Int) {
//  data1 = 20 // 전달되는 매개변수는 val, 변경 불가능
//}

// 3-1. 파라미터에 기본값 선언
/*
fun main(){
  fun some(data1 : Int, data2 : Int = 10) : Int{ // 파라미터의 기본값을 지정
    return data1 * data2;
  }
  println(some(10)) // data2에 기본값 10 적용
  println(some(10, 20)) // data2에 전달된 20 wjrdyd
  println(some(data2=20, data1=10)) // 명시적으로 매개변수명을 지정해서 값을 넣을 수도 있다.
}*/

// 4. 컬렉션 타입
// 4-1. Array - 배열
/*fun main() {
  val data1 : Array<Int> = Array(3, {0}) // 생성자는 (크기, 초기값)으로 구성
  println("""
    array size : ${data1.size}
    array data : ${data1[0]}, ${data1[1]}, ${data1[2]} 
  """.trimIndent())

  data1[0] = 10
  data1[1] = 20
  data1.set(2, 30) // 인덱스 2에 30을 넣겠다

  println("""
    array size : ${data1.size}
    array data : ${data1[0]}, ${data1[1]}, ${data1[2]} 
  """.trimIndent())
}*/

// 4-2. 기초 타입의 배열
/*val data1 : IntArray = IntArray(3, {0})
val data2 : BooleanArray = BooleanArray(3, {false})
fun main(){
  data2[2] = true
  println("${data1[1]}, ${data2[2]}")
}*/

// 4-3. arrayOf() - 배열 선언 시 값 할당
/*val data1 = arrayOf(0, 20, 30)
val array = booleanArrayOf(true, true, true)
fun main(){
  val data1 = arrayOf(); //여기 조느라 덜 적었음 ㅜㅜ

}*/

// 4-4. List, set, Map(불변 .. get과 size만 가능)
/*fun main(){
  var list = listOf<Int>(10, 20, 30)
  println("""
    list.size : ${list.size}
    list data : ${list[0]}, ${list[1]}, ${list.get(2)}
  """.trimIndent())

  list.add(3, 40) // 불변함
}*/

// 4-5. mutableList (가변, add, set 가능)
/*fun main(){
  var mutableList = mutableListOf<Int>(10, 20, 30)
  mutableList.add(3, 40)
  mutableList.set(0, 50)
  println("""
    list.size : ${mutableList.size}
    list data : ${mutableList[0]}, ${mutableList[1]}, ${mutableList.get(2)}
  """.trimIndent())
}*/

// list : 순서 유, 데이터 중복 허용
 // set : 순서 무, 데이터 중복 불허용
// map : 키 밸류 조합으로 구성, 순서 무, 키 중복 불허용

// 4-6. map

fun main() {
  var map = mapOf<String, String>(Pair("one", "hello"), "two" to "world") // 변수 선언 방법
  // 키, 밸류 지정하는 방법 : Pair 객체 이용 또는 '키 to 밸류'
  println("""
    map size : ${map.size}
    map data : ${map.get("one")}, ${map.get("two")}
  """.trimIndent())
}
