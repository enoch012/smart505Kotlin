package com.busanit.androidlab

import android.app.backup.BackupAgent
import android.provider.ContactsContract.CommonDataKinds.Email
import java.util.concurrent.CountDownLatch

// 1. 클래스 선언
/*
class User {
  var name = "noah" // 멤버 변수
  constructor(name : String) { // 코틀린식 생성자 형태
    this.name = name
  }

  constructor()

  fun someFun(){
    println("name : $name")
  }

  class SomeClass {
  }
}

fun main() {
  val user1 = User()
  val user2 = User("yudah")
  user1.someFun();
}*/

// 1-1. 주 생성자 : 클래스 생성자는 주 생성자, 보조 생성자로 구분 된다
/*
class User constructor(){ // 클래스 선언부에 constructor 키워드로 주 생성자를 선언 (생략도 가능)
}

class User(){} // constructor 키워드 생략 가능*/

// class User{} // 주생성자 선언하지 않으면 매개 변수 없는 주 생성자를 자동으로 추가

// 1-2. 매개변수 있는 주 생성자

/*
class User(name : String, count : Int){
  init {
    println("i am init...") // init 영역은 객체 생성시 자동 실행
  }
}

fun main(){
  val user = User("noah", 21)
}*/

// 1-3. 매개변수를 멤버변수로 사용하는 방법
/*class User (name : String, count : Int){
  lateinit var name : String
  var count : Int = 0 // 멤버 변수 선언
  init {
    this.name = name
    this.count = count // init 영역에서 매개변수 값 대입
  }

  fun someFun(){
    println("name : $name, count : $count")
  }
}

fun main() {
  val user = User("noah", 21)
  user.someFun()
}*/

// 1-4. 매개변수를 val var로 선언 -> 바로 멤버변수로 사용 가능

/*
class User(val name : String, val age : Int){
  // 멤버변수 선언, 초기화, 값 대입 과정 생략할 수 있음
  fun someFun(){
    println("name : $name, age : $age")
  }
}

fun main() {
  val user = User("Noah", 21)
  user.someFun()
}*/

// 2. 보조 생성자, 클래스의 본문에 constructor 키워드로 선언, 여러개 추가 가능

/*
class User {
  constructor(name : String){
    println("constructor(name : String) call ... ")
  }

  constructor(name : String, age : Int){
    println("constructor(name : String, count : Int) call ... ")
  }
}

fun main() {
  val user1 = User("noah")
  val user2 = User("noah", 21)
}*/

// 2-1. 주 생성자, 보조 생성자 함께 사용
/*
class User(name : String){
  constructor(name : String, age : Int) :this(name) { // 주생성자에서 받은 값을 보조 생성자에 넣어줘야(this(name)) 오류가 안 난다
  }
}*/

//2-2. 보조생성자 여러개 사용
/*
class User(name : String){

  lateinit var name : String
  var age : Int = 0
  lateinit var email : String

  constructor(name : String, age : Int) : this(name) {}
  constructor(name : String, age : Int, email : String) : this (name, age){} // 오버라이딩

  init {
    this.name = name
    this.age = age
    this.email = email
  }

  fun someFun(){
    println("name : $name, age : $age, email : $email")
  }
}

fun main() {
  val user = User("noah", 21, "yudah@com")
  user.someFun()
}*/

// 3. 상속
/*open class Super {} // open 키워드를 써서 선언해야 다른 클래스에서 상속 가능

class Sub : Super(){} // 클래스 선언부에서 콜론 뒤에 상속받을 클래스명 입력
                      // Super() 상속 받으면서, super 클래스의 매개변수 없는 생성자 호출 */

// 3-1. 매개변수 있는 생성자

/*open class Super(name : String){}

class Sub(name: String) : Super(name){} // 매개변수 구성에 맞게 전달*/

// 3-2. 부모클래스 함수 사용

/*
open class Super {
  var superData = 10
  fun superFun(){
    println("i am super Fun : $superData")
  }
}

class Sub : Super() {}

fun main() {
  val obj = Sub() // Sub 클래스 객체 생성
  obj.superData = 20 // Sub 클래스 객체를 이용해 Super 클래스 변수, 함수 사용
  obj.superFun()
}
*/

// 3-3. 오버라이딩 규칙
/*
open class Super {
  open var someData = 10 // 오버라이딩을 허용할 변수, 함수에 open 키워드 사용
  open fun someFun(){
    println("i am super class function : $someData")
  }
}

class Sub : Super() {
  override var someData = 20 // 오버라이딩 할 변수, 함수에 override 키워드 사용
  override fun someFun(){
    println("i am sub class function : $someData")
  }
}

fun main(){
  val obj = Sub()
  obj.someFun()
}*/

// 4. 접근제한자 - public(모든 클래스), internal(자바의 default, 같은 모듈), protected(상속 관계도 허용), private(자기 클래스 내부만)

/*
open class Super {
  var publicData = 10 // 생략할 경우 public
  protected var protectedData = 20
  private var privateData = 30
}

class Sub : Super(){
  fun subFun(){
    publicData++
    protectedData++
    */
/*privateData++ // 접근 불가 오류생김*//*


    println(" publicData : $publicData, protectedData : $protectedData")
  }
}

fun main() {
  val obj = Super()

  obj.publicData
  obj.protectedData
  obj.privateData

  obj.subFun()
}*/

// 5. 클래스 종류, 데이터 클래스(jsp에서의 dto)

/*
class NonDataClass (val name : String, val email: String, val age : Int) // 일반 클래스
data class DataClass(val name : String, val email: String, val age : Int) // 데이터클래스 선언 (data 키워드)

fun main() {
  val non1 = NonDataClass("yudah", "fox@com", 30)
  val non2 = NonDataClass("yudah", "fox@com", 30)

  val data1 = DataClass("noah", "cat@com", 21)
  val data2 = DataClass("noah", "cat@com", 21)

  println("non data class equals : ${non1.equals(non2)}") // 일반 클래스는 객체 주소 비교
  println("data class equals : ${data1.equals(data2)}") // 데이터 클래스로 선언했기 때문에 주소가 아닌 데이터를 비교하여 true가 나옴
}
*/

// 5-1. 데이터 클래스 equals() : 주생성자의 매개변수 데이터만 비교

/*
data class DataClass(val name : String, val email : String, val age : Int){
  lateinit var address : String
  constructor(name : String, email: String, age: Int, address: String) : this(name, email, age){
    this.address = address
  }
}

fun main() {
  val obj1 = DataClass("noah", "cat@com", 21, "canada")
  val obj2 = DataClass("noah", "cat@com", 21, "england")

  println("obj1.equals(obj2) : ${obj1.equals(obj2)}") // 결과 true : 보조생성자로 만든 address는 비교 안 함
}*/

// 5-2. 데이터 클래스 toString() 함수
fun main() {
  class NonDataClass(val name : String, val email : String, val age : Int)
  data class DataClass(val name : String, val email : String, val age : Int)

  val non = NonDataClass("noah", "cat@com", 21)
  val data = DataClass("noah", "cat@com", 23)

  println(" non data class toString : ${non.toString()}")
  println(" data class toString : ${data.toString()}") // 각각 입력된 주소 값을 통해 어떤 차이가 나는 지 알 수 있다.
}