import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.AggregateOperator;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.operators.FlatMapOperator;
import org.apache.flink.api.java.operators.MapOperator;
import org.apache.flink.util.Collector;
import org.apache.flink.api.java.tuple.Tuple2;

public class JavaWordCount {
    public static void main(String[] args) throws Exception {
        //获取执行环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        //读取本地文件
        DataSource<String> textFile = env.readTextFile("D:\\wordCount\\wordCount.txt");
        //转换
        FlatMapOperator<String, String> words = textFile.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public void flatMap(String s, Collector<String> collector) throws Exception {
                String[] words = s.split(" ");
                for (String word : words) {
                    collector.collect(word);
                }
            }
        });

        MapOperator<String, Tuple2<String, Integer>> tuple = words.map(new MapFunction<String, Tuple2<String, Integer>>() {
            @Override
            public Tuple2<String, Integer> map(String s) throws Exception {
                return Tuple2.of(s, 1);
            }
        });

        AggregateOperator<Tuple2<String, Integer>> wordAndCount = tuple.groupBy(0).sum(1);

        wordAndCount.print();
    }
}
