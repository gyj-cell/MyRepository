import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.table.catalog.ResolvedSchema;
import org.apache.flink.types.Row;
import org.apache.flink.util.Collector;

public class JavaFlinkSQLWordCount {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        StreamTableEnvironment tableEnv = StreamTableEnvironment.create(env);


        DataStreamSource<String> textFile = env.readTextFile("src/main/resources/wordCount.txt");

        SingleOutputStreamOperator<String> word = textFile.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public void flatMap(String value, Collector<String> out) throws Exception {
                String[] s = value.split(" ");
                for (String s1 : s) {
                    out.collect(s1);
                }
            }
        }).map(new MapFunction<String, String>() {
            @Override
            public String map(String value) throws Exception {
                return value;
            }
        });

        Table table = tableEnv.fromDataStream(word,"word");
        tableEnv.createTemporaryView("wordcount", table);

        ResolvedSchema resolvedSchema = table.getQueryOperation().getResolvedSchema();
        System.out.println(resolvedSchema);

        Table table1 = tableEnv.sqlQuery("select word,count(word) from wordcount group by word");

        tableEnv.toRetractStream(table1, Row.class).filter(x -> x.f0).map(x -> x.f1).print();

        env.execute(JavaFlinkSQLWordCount.class.getName());

    }
}


