package controllers;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.databind.JsonNode;
import models.MoviBusVehiculo;
import models.TranviaVehiculo;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;


/**
 * Created by USER on 14/08/2015.
 */
public class TranviaVehController extends VehiculoController {

    @BodyParser.Of(BodyParser.Json.class)
    public Result create() {
        JsonNode j = Controller.request().body().asJson();
        TranviaVehiculo tranvia = TranviaVehiculo.bind(j);
        tranvia.save();
        return ok(Json.toJson(tranvia));
    }


    @BodyParser.Of(BodyParser.Json.class)
    public Result putTranvia(String idTranvia)
    {
        TranviaVehiculo original = (TranviaVehiculo) TranviaVehiculo.finder.byId(idTranvia);
        original.delete();
        JsonNode j = Controller.request().body().asJson();
        TranviaVehiculo reemplazarPor = TranviaVehiculo.bind(j);
        original = reemplazarPor;
        original.save();
        return ok(Json.toJson(original));
    }

    public Result readAll() {
        List<TranviaVehiculo> tranvias = TranviaVehiculo.finder.all();
        return ok(Json.toJson(tranvias));
    }

    public Result readTranvia(String idTranvia) {
        Result rta;
        TranviaVehiculo tranvia = (TranviaVehiculo) TranviaVehiculo.finder.byId(idTranvia);
        if (tranvia != null) {
            rta = ok(Json.toJson(tranvia));
        } else {
            rta = notFound();
        }
        return rta;
    }


}