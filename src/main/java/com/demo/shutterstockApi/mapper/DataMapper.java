//package com.demo.shutterstockApi.mapper;
//
//import com.demo.shutterstockApi.dto.DataDto;
//import com.demo.shutterstockApi.entity.Data;
//
//public class DataMapper {
//
//    // Map to DataDto
//    public static DataDto toDataDto(Data data, DataDto datadto) {
//        datadto.setVerdict_time(data.getVerdict_time());
//        datadto.setUser_name(data.getUser_name());
//        datadto.setContributor(data.getContributor());
//        datadto.setVerdict(data.getVerdict());
//        datadto.setReason(data.getReason());
//        datadto.setRatings(data.getRatings());
//        datadto.setTitle(data.getTitle());
//        datadto.setKeywords(data.getKeywords());
//        return datadto;
//    }
//
//    // Map to Data
//    public static Data toData(DataDto datadto, Data data) {
//        data.setVerdict_time(datadto.getVerdict_time());
//        data.setUser_name(datadto.getUser_name());
//        data.setContributor(datadto.getContributor());
//        data.setVerdict(datadto.getVerdict());
//        data.setReason(datadto.getReason());
//        data.setRatings(datadto.getRatings());
//        data.setTitle(datadto.getTitle());
//        data.setKeywords(datadto.getKeywords());
//        return data;
//    }
//
//}
