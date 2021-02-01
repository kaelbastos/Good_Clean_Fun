package org.kaelbastos.Domain.UseCases.ReportUseCases;

import org.kaelbastos.Domain.Entities.Reports.WorkerReport;
import org.kaelbastos.Domain.Entities.Service.Service;
import org.kaelbastos.Domain.Entities.Worker.Worker;
import org.kaelbastos.Persistance.PersistenceFacade;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenerateWorkersReport {
    public List<WorkerReport> generate(){
        List<WorkerReport> report = new ArrayList<>();
        Optional<List<Worker>> workers = PersistenceFacade.getInstance().getAllWorkers();

        workers.ifPresent(workersList -> {
            workersList.forEach(worker -> {
                WorkerReport workerReport = new WorkerReport(worker);
                Optional<List<Service>> workerServices = PersistenceFacade.getInstance().getServiceByWorker(worker.getCpf());

                workerServices.ifPresent(services -> {
                    services.forEach(service -> {
                        if(service.isPayed())
                            workerReport.addPayedService(service);
                        else
                            workerReport.addOpenService(service);
                    });
                });

            });
        });

        return report;
    }
}
