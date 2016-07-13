package foo;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsTest {

	public static void main(String[] args) {
		String v =Arrays.asList(StringUtils.split("demoiselle-pp_www", "_-"))
			.stream()
			.map(StringUtils::capitalize)
			.collect(Collectors.joining());
		System.out.println(v);	
			
	}

}
