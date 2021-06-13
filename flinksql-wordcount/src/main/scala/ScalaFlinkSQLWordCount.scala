import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}
import org.apache.flink.streaming.api.scala._
import org.apache.flink.table.api.{EnvironmentSettings, Table}
import org.apache.flink.table.api.bridge.scala.StreamTableEnvironment
import org.apache.flink.types.Row
object ScalaFlinkSQLWordCount {
  def main(args: Array[String]): Unit = {
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    env.setParallelism(1)
    val tableEnv: StreamTableEnvironment = StreamTableEnvironment.create(env)

    val textFile: DataStream[String] = env.readTextFile("src/main/resources/wordCount.txt")

    val word: DataStream[wordcount] = textFile.flatMap(_.split(" ")).map(wordcount(_))

    val table: Table = tableEnv.fromDataStream(word)

    val table1: Table = tableEnv.sqlQuery(
      s"""
         |select
         |word,count(word)
         |from $table
         |group by word
         |""".stripMargin)

    tableEnv.toRetractStream[Row](table1).filter(_._1).map(x => x._2).print()

    env.execute(this.getClass.getName)
  }
}
case class wordcount(word:String)

