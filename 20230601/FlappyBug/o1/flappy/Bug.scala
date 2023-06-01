package o1.flappy

import o1._

// Define class Bug here.
 class Bug ( var initialPos: Pos ) {
  
  private var currentPos = initialPos
  def pos = this.currentPos
  
  val radius = BugRadius
 
  var yVelocity = 0.0
 
 def fall() = {
   //this.pos = this.pos.addY(FallingSpeed)
   //this.pos = this.pos.clampY(0, ViewHeight-GroundDepth)// 버그가 화면 밖으로 나가지 않도록 x,y를 clamp()메서드를 이용하여 조정.(y는 땅 위에 떨어지도록 설정)
   //위치를 아예 바꿔줘야 하기 때문에 this.pos = 하고 공식 작성.
   //this.move(FallingSpeed)
    if (currentPos.y < 350) yVelocity = yVelocity + 2
   this.move(yVelocity)
   
 }
 def flap (WingPower: Double) {
  // this.pos = this.pos.addY(-WingPower)
  // this.pos = this.pos.clampY(0, ViewHeight-GroundDepth) 똑같은 함수를 fall과 flap두 개 작성하기엔 비효율적이므로 move라는 함수를 만들어서 적용.
   //this.move(-WingPower)
   this.yVelocity = this.yVelocity - WingPower // yVelocity 값 업데이트
  //this.move(yVelocity)
 }
 
 def move (dy: Double) = {
   this.currentPos = this.currentPos.addY(dy)
   this.currentPos = this.currentPos.clampY(0, ViewHeight-GroundDepth)
 }
 override def toString = "center at ( " + pos.x + "," + pos.y + "), radius " + BugRadius
}
