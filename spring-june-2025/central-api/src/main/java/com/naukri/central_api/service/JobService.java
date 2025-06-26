package com.naukri.central_api.service;

import com.naukri.central_api.connectors.DatabaseApiConnector;
import com.naukri.central_api.models.Job;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {


    DatabaseApiConnector databaseApiConnector;

    public JobService(DatabaseApiConnector databaseApiConnector){
        this.databaseApiConnector = databaseApiConnector;
    }

    public List<Job> searchJobs(String title, String companyName, String location){
        // Create sql query
    }


    public String createJobSearchQuery(String title, String companyName, String location){
        String query = "select * from job"
    }

    public Job saveJob(Job job){
        return databaseApiConnector.callSaveJobEndpoint(job);
    }
}
