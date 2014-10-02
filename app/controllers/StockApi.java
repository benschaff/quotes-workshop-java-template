package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ChartRequest;
import models.ChartRequestElement;
import models.Symbol;
import org.joda.time.DateTimeConstants;
import play.Logger;
import play.Play;
import play.Routes;
import play.cache.Cache;
import play.libs.F;
import play.libs.Json;
import play.libs.ws.WS;
import play.libs.ws.WSRequestHolder;
import play.libs.ws.WSResponse;
import play.mvc.Controller;
import play.mvc.Result;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class StockApi extends Controller {

    private final static String SYMBOLS_API_URL = Play.application().configuration().getString("markitondemand-api.lookup");

    private final static String CHART_DATA_API_URL = Play.application().configuration().getString("markitondemand-api.chartData");

    private final static Logger.ALogger logger = Logger.of(StockApi.class);

    public static F.Promise<Result> symbols(final String query) {
        throw new UnsupportedOperationException("symbols operation is not implemented");
    }

    public static F.Promise<Result> last30Days(final String symbol) {
        throw new UnsupportedOperationException("last30Days operation is not implemented");
    }

    public static Result javascriptRoutes() {
        return ok(Routes.javascriptRouter(
                "stockApiJavascriptRoutes",
                routes.javascript.StockApi.last30Days(),
                routes.javascript.StockApi.symbols()
        )).as("text/javascript");
    }

}
