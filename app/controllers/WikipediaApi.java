package controllers;

import models.Symbol;
import play.Logger;
import play.Play;
import play.Routes;
import play.libs.F;
import play.mvc.Controller;
import play.mvc.Result;

public class WikipediaApi extends Controller {

    private final static Logger.ALogger logger = Logger.of(WikipediaApi.class);

    private static final String WIKIPEDIA_API_PAGE_SEARCH = Play.application().configuration().getString("wikipedia-api.lookup");

    private static final String WIKIPEDIA_API_PAGE_GET = Play.application().configuration().getString("wikipedia-api.page");

    public static F.Promise<Result> vcard() {
        throw new UnsupportedOperationException("vcard operation is not implemented");
    }

    private static String toWikipediaApiLookupQueryPath(final Symbol symbol) {
        return symbol.symbol + "|" + symbol.name + "|" + symbol.name.split(" ")[0];
    }

    public static Result javascriptRoutes() {
        return ok(Routes.javascriptRouter(
                "wikipediaApiJavascriptRoutes",
                routes.javascript.WikipediaApi.vcard()
        )).as("text/javascript");
    }

}
