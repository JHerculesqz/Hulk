package com.firelord.spring.component.tmp.db.es;

//import org.elasticsearch.action.admin.cluster.state.ClusterStateResponse;
//import org.elasticsearch.action.get.GetResponse;
//import org.elasticsearch.action.index.IndexResponse;
//import org.elasticsearch.action.search.SearchResponse;
//import org.elasticsearch.action.update.UpdateResponse;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.TransportAddress;
//import org.elasticsearch.common.xcontent.XContentType;
//import org.elasticsearch.index.query.MatchAllQueryBuilder;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.elasticsearch.search.SearchHit;
//import org.elasticsearch.transport.client.PreBuiltTransportClient;

//import java.net.InetAddress;
//import java.net.UnknownHostException;
//import java.util.ArrayList;
//import java.util.List;

public class EsUtilsEx {
//    //#region Const
//
//    private static final String CLUSTER_NAME = "my-application";
//    private static final String IP = "127.0.0.1";
//    private static final int PORT = 9300;
//
//    //#endregion
//
//    //#region connect
//
//    public static EsConnect connect() throws UnknownHostException {
//        Settings oSettings = Settings.builder()
//                .put("cluster.name", CLUSTER_NAME)
//                .put("client.transport.sniff", true)
//                .build();
//        TransportClient oClient = new PreBuiltTransportClient(oSettings)
//                .addTransportAddress(new TransportAddress(InetAddress.getByName(IP), PORT));
//        EsConnect oEsConnect = new EsConnect(oClient);
//        return oEsConnect;
//    }
//
//    //#endregion
//
//    //#region index(db)
//
//    public static boolean addIndex(EsConnect oEsConnect, String strIndex) {
//        return isIndexExists(oEsConnect, strIndex) ? false :
//                oEsConnect.getClient().admin().indices().prepareCreate(strIndex).execute().actionGet().isAcknowledged();
//    }
//
//    public static boolean delIndex(EsConnect oEsConnect, String strIndex) {
//        return isIndexExists(oEsConnect, strIndex) ? false :
//                oEsConnect.getClient().admin().indices().prepareDelete(strIndex).execute().actionGet().isAcknowledged();
//    }
//
//    public static boolean isIndexExists(EsConnect oEsConnect, String strIndex) {
//        return oEsConnect.getClient().admin().indices().prepareExists(strIndex).execute().actionGet().isExists();
//    }
//
//    public static String[] getAllIndexs(EsConnect oEsConnect) {
//        ClusterStateResponse response = oEsConnect.getClient().admin().cluster().prepareState().execute().actionGet();
//        return response.getState().getMetaData().getConcreteAllIndices();
//    }
//
//    //#endregion
//
//    //#region type(tbl)
//
//    public static boolean isTypeExists(EsConnect oEsConnect, String strIndex, String strType) {
//        return isIndexExists(oEsConnect, strIndex) ? oEsConnect.getClient()
//                .admin().indices().prepareTypesExists(strIndex).setTypes(strType).execute().actionGet().isExists()
//                : false;
//    }
//
//    //#endregion
//
//    //#region document(row)
//
//    public static IndexResponse addDocment(EsConnect oEsConnect, String strIndex, String strType,
//                                           String strDocument) {
//        return oEsConnect.getClient().prepareIndex(strIndex, strType)
//                .setSource(strDocument, XContentType.JSON).get();
//    }
//
//    public static UpdateResponse updateDocument(EsConnect oEsConnect, String strIndex,
//                                                String strType, String strId,
//                                                String strDocument) {
//        return oEsConnect.getClient().prepareUpdate(strIndex, strType, strId)
//                .setDoc(strDocument, XContentType.JSON).get();
//    }
//
//    //#endregion
//
//    //#region search
//
//    public static List<String> matchAllQuery(EsConnect oEsConnect, String strIndex) {
//        List<String> lstRes = new ArrayList<>();
//
//        MatchAllQueryBuilder oQuery = QueryBuilders.matchAllQuery();
//        SearchResponse oResponse = oEsConnect.getClient().prepareSearch(strIndex).setQuery(oQuery)
//                .execute().actionGet();
//        for (SearchHit oSearchHit : oResponse.getHits()) {
//            String strJson = oSearchHit.getSourceAsString();
//            lstRes.add(strJson);
//        }
//
//        return lstRes;
//    }
//
//    public static List<String> matchAllQueryInType(EsConnect oEsConnect, String strIndex,
//                                                   String strType) {
//        List<String> lstRes = new ArrayList<>();
//
//        MatchAllQueryBuilder oQuery = QueryBuilders.matchAllQuery();
//        SearchResponse oResponse = oEsConnect.getClient().prepareSearch(strIndex)
//                .setTypes(strType)
//                .setQuery(oQuery)
//                .execute().actionGet();
//        for (SearchHit oSearchHit : oResponse.getHits()) {
//            String strJson = oSearchHit.getSourceAsString();
//            lstRes.add(strJson);
//        }
//
//        return lstRes;
//    }
//
//    public static String matchAllQueryInTypeById(EsConnect oEsConnect, String strIndex,
//                                                 String strType, String strId) {
//        GetResponse oRes = oEsConnect.getClient().prepareGet(strIndex, strType, strId).get();
//        return oRes.getSourceAsString();
//    }
//
//    //查询,支持查子节点
//    //多文档查询
//    //批量CUD
//    //词频统计
//    //js的查询,query指定mapping
//    //sort/分页
//    //search评分
//    //scroll query
//    //dsl
//
//    //#endregion
}
