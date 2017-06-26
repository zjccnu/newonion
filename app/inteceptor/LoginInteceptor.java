package inteceptor;

import play.libs.F.Promise;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.SimpleResult;
public class LoginInteceptor extends Action.Simple{
	public Promise<SimpleResult> call(Http.Context ctx) throws Throwable {
		return delegate.call(ctx);
    }
}
