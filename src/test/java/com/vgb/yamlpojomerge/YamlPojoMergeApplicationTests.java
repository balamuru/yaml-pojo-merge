package com.vgb.yamlpojomerge;

import com.vgb.yamlpojomerge.data.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("prod")
public class YamlPojoMergeApplicationTests {

	@Autowired
	Credentials credentials;

	@Autowired
	AllCredentials allCredentials;

	@Autowired
	AllCredentialsMap allCredentialsMap;
	@Autowired
	MyJmsConfiguration myJmsConfiguration;

	@Autowired
	FamilyCredentials familyCredentials;

	//works, a container containing simple strings
	@Test
	public void testCredentials() {
		assertThat(credentials.getUser(), is(equalTo("jdoe")));
		assertThat(credentials.getPassword(), is(equalTo("Top$ecret!")));
	}

	//doesn't work, a container containing a collection (potentially unbounded) of instances
	@Test(expected = AssertionError.class)
	public void testAllCredentials() {
		Credentials credentials1 = allCredentials.getCredentials().get(0);
		Credentials credentials2 = allCredentials.getCredentials().get(1);

		assertThat(credentials1.getUser(), is(equalTo("bill")));
		assertThat(credentials1.getPassword(), is(equalTo("monic@")));

		assertThat(credentials2.getUser(), is(equalTo("hilary")));
		assertThat(credentials2.getPassword(), is(equalTo("my_em@ilz")));
	}

	@Test
	public void testAllCredentialsMap() throws Exception {
		Credentials credentials1 = allCredentialsMap.getCredentials().get("mr_prez");
		Credentials credentials2 = allCredentialsMap.getCredentials().get("first_lady");

		assertThat(credentials1.getUser(), is(equalTo("bill")));
		assertThat(credentials1.getPassword(), is(equalTo("monic@")));

		assertThat(credentials2.getUser(), is(equalTo("hilary")));
		assertThat(credentials2.getPassword(), is(equalTo("my_em@ilz")));
	}

	//works, a container class containing discrete instances
	@Test
	public void testFamilyCredentials() {
		Credentials credentials1 = familyCredentials.getHusband();
		Credentials credentials2 = familyCredentials.getWife();

		assertThat(credentials1.getUser(), is(equalTo("bill")));
		assertThat(credentials1.getPassword(), is(equalTo("monic@")));

		assertThat(credentials2.getUser(), is(equalTo("hilary")));
		assertThat(credentials2.getPassword(), is(equalTo("my_em@ilz")));
	}

	//works, a container class containing maps
	@Test
	public void testMyJmsCredentials() {
		assertThat(myJmsConfiguration.getActivemq().get("brokerUrl"), is(equalTo("tcp://xyz.com:61646")));
		assertThat(myJmsConfiguration.getActivemq().get("brokerName"), is(equalTo("broker2")));
		assertThat(myJmsConfiguration.getActivemq().get("queueName"), is(equalTo("some_queue")));

		assertThat(myJmsConfiguration.getWmq().get("hostName"), is(equalTo("jms.xyz.com")));
		assertThat(myJmsConfiguration.getWmq().get("queueManager"), is(equalTo("qmgr_123")));
		assertThat(myJmsConfiguration.getWmq().get("port"), is(equalTo("11401")));
		assertThat(myJmsConfiguration.getWmq().get("channel"), is(equalTo("WF.JAVA.CLIENT")));
		assertThat(myJmsConfiguration.getWmq().get("transportType"), is(equalTo("1")));
		assertThat(myJmsConfiguration.getWmq().get("queueName"), is(equalTo("queue_123")));



	}


}
