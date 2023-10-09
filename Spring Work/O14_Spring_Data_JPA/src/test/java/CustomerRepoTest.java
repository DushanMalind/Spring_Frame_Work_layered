import lk.ijse.spring.config.WebRootConfig;

//So for testing we have to use testing context which is provided by Spring
//And also these testing can be integrated with any testing vendor like Jupiter
//So here you can see how to configure the texting context with Spring & Jupiter using annotations

//@WebAppConfiguration//creat the testing context
//@ContextConfiguration(classes = {WebRootConfig.class}) // add configuration for that context
//@ExtendWith(SpringExtension.class) // integrate junit with Spring
//@Transactional
class CustomerRepoTest {
}
