trait Gender
case object Male extends Gender
case object Female extends Gender


case class Runner(name:String,time:Int,gender:Gender)
case class RunResult(r:Runner,rank:Int,genderRank:Int,competitive:Int)

object Runners extends App{

  val runners:List[Runner] = {
    List(Runner("Shirley",30,Female),Runner("Avi",26,Male),Runner("Ronen",25,Male),Runner("Rinat",24,Female))
  }

  println("welcome to TLV Marathon")
  println(transform())

  def transform():List[RunResult] = {
    val all = runners.sortBy(_.time)
      .zipWithIndex
      .foldLeft(List[RunResult]())(calcCompetitive)

    (rankGender(all,Male) ++ rankGender(all,Female))
      .sortBy(_.rank)

  }

  def rankGender(lst:List[RunResult],g:Gender):List[RunResult] = {
    lst.filter(_.r.gender == g)
      .zipWithIndex
      .map(r=>{
        RunResult(r._1.r,r._1.rank,r._2+1,r._1.competitive)
      })
  }

  def calcCompetitive(acc:List[RunResult], cur:(Runner,Int)): List[RunResult] = {
    val competitive = acc.size match {
      case 0 => 0
      case _ => acc.last.r.time
    }
    acc :+ RunResult(cur._1,cur._2+1,0,competitive)
  }
}
