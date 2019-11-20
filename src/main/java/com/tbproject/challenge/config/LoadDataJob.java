//package com.tbproject.challenge.config;
//
//
//import com.tbproject.challenge.model.Vehicle;
//import com.tbproject.challenge.model.VehicleDetail;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.data.MongoItemWriter;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.batch.item.file.mapping.DefaultLineMapper;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.data.mongodb.core.MongoTemplate;
//
//@EnableBatchProcessing
//@Configuration
//public class LoadDataJob {
//
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    @Bean
//    public Job readCSVFile() {
//        return jobBuilderFactory.get("readCSVFile").incrementer(new RunIdIncrementer()).start(step1())
//                .build();
//    }
//
//    @Bean
//    public Step step1() {
//        return stepBuilderFactory.get("step1").<VehicleDetail, Vehicle>chunk(10).reader(reader())
//                .writer(writer()).build();
//    }
//
//    @Bean
//    public FlatFileItemReader<VehicleDetail> reader() {
//        FlatFileItemReader<VehicleDetail> reader = new FlatFileItemReader<>();
//        reader.setResource(new ClassPathResource("bus_data.csv"));
//        reader.setLineMapper(new DefaultLineMapper<VehicleDetail>() {{
//            setLineTokenizer(new DelimitedLineTokenizer() {{
//                setNames(new String[]{"timestamp", "lineId",
//                        "direction", "journeyPatternId", "timeFrame", "vehicleJourneyId", "operator",
//                "congestion", "longitude", "latitude", "delay", "blockId","vehicleId", "stopId", "atStop"});
//            }});
//            setFieldSetMapper(new BeanWrapperFieldSetMapper<VehicleDetail>() {{
//                setTargetType(VehicleDetail.class);
//            }});
//        }});
//        return reader;
//    }
//
//    @Bean
//    public MongoItemWriter<Vehicle> writer() {
//        MongoItemWriter<Vehicle> writer = new MongoItemWriter<Vehicle>();
//        writer.setTemplate(mongoTemplate);
//        writer.setCollection("vehicle");
//        return writer;
//    }
//}
