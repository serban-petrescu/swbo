package spet.sbwo.api.service.transfer;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import spet.sbwo.api.service.base.BaseService;
import spet.sbwo.api.service.base.IPrivate;
import spet.sbwo.control.channel.expertise.CourtImportChannel;
import spet.sbwo.control.controller.transfer.CourtImportController;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Path("/import")
public class CourtImportService extends BaseService implements IPrivate {
    private CourtImportController controller;

    public CourtImportService(CourtImportController controller) {
        this.controller = controller;
    }

    @POST
    @Path("/courts/{separator}/{header}")
    public void importCourtsFromCsv(@PathParam("separator") String separator, @PathParam("header") boolean header,
                                    InputStream body) {
        CSVFormat format = CSVFormat.DEFAULT.withDelimiter(separator.charAt(0)).withSkipHeaderRecord(header);
        try (CSVParser parser = new CSVParser(new InputStreamReader(body), format)) {
            controller.importCourts(extractChannels(parser));
        } catch (Exception e) {
            throw mapException(e);
        }
    }

    private List<CourtImportChannel> extractChannels(CSVParser parser) {
        List<CourtImportChannel> channels = new ArrayList<>();
        for (CSVRecord record : parser) {
            channels.add(new CourtImportChannel(record.get(0), record.get(1)));
        }
        return channels;
    }
}
