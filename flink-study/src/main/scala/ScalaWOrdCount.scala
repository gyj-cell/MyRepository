import org.apache.flink.api.scala.ExecutionEnvironment
import org.apache.flink.api.scala._

object ScalaWOrdCount {
  def main(args: Array[String]): Unit = {
    //获取执行环境
    val env = ExecutionEnvironment.getExecutionEnvironment
    //读取本地文件
    val textFile = env.readTextFile("D:\\wordCount\\wordCount.txt")
    //转换统计单词个数
    textFile.flatMap(_.split(" "))
      .map((_, 1))
      .groupBy(0)
      .sum(1)
      .print()
  }
}
