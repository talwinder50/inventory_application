package profiles;

import org.springframework.context.annotation.Profile;

@Profile(Production.NAME)
public @interface Production {
	String NAME="production";
}
