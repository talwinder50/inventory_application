package profiles;

import org.springframework.context.annotation.Profile;

@Profile(Mock.NAME)
public @interface Mock {
	String NAME="mock";
}
