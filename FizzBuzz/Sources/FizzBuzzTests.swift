import XCTest
@testable import FizzBuzz

class FizzBuzzTests: XCTestCase {
  var fizzbuzz: FizzBuzz!
  
  override func setUp() {
    super.setUp()
    self.fizzbuzz = FizzBuzz()
  }
  
  func testCheck_returnsFizzBuzz() {
    XCTAssertEqual(self.fizzbuzz.check(15), "FizzBuzz!")
  }
  
  func testCheck_returnsFizz() {
    XCTAssertEqual(self.fizzbuzz.check(9), "Fizz!")
  }
  
  func testCheck_returnsBuzz() {
    XCTAssertEqual(self.fizzbuzz.check(10), "Buzz!")
  }
  
  func testCheck_returnsNumber() {
    XCTAssertEqual(self.fizzbuzz.check(11), "11")
  }
}