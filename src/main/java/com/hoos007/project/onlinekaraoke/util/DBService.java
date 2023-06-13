package com.hoos007.project.onlinekaraoke.util;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.List;
import java.util.Map;

@Service
public class DBService {
    private final DynamoDbClient dynamoDbClient;

    public DBService(DynamoDbClient dynamoDbClient) {
        this.dynamoDbClient = dynamoDbClient;
    }

    public boolean addRoomItem(String tableName, String room_id, String room_name, String room_cnt, String room_user) {
        PutItemRequest request = PutItemRequest.builder()
            .tableName(tableName)
            .item(Map.of(
                    "room_id", AttributeValue.builder().s(room_id).build(),
                    "room_name", AttributeValue.builder().s(room_name).build()
//                    "room_cnt", AttributeValue.builder().n(String.valueOf(room_cnt)).build(),
//                    "room_user", AttributeValue.builder().s(room_user).build()
            ))
            .build();

        try {
            dynamoDbClient.putItem(request);
            return true; // 성공적으로 아이템 추가됨
        } catch (DynamoDbException e) {
            // 아이템 추가 실패, 예외 처리
            return false;
        }
    }

    public void addUserIDItem(String tableName, String user_id) {
        PutItemRequest request = PutItemRequest.builder()
                .tableName(tableName)
                .item(Map.of(
                        "id", AttributeValue.builder().s(user_id).build()
                ))
                .build();

        dynamoDbClient.putItem(request);
    }

    public void updateItem(String tableName, String room_id, String updatedRoomName) {
        UpdateItemRequest request = UpdateItemRequest.builder()
                .tableName(tableName)
                .key(Map.of("room_id", AttributeValue.builder().s(room_id).build()))
                .attributeUpdates(Map.of("room_name", AttributeValueUpdate.builder()
                        .value(AttributeValue.builder().s(updatedRoomName).build())
                        .action(AttributeAction.PUT)
                        .build()))
                .build();

        dynamoDbClient.updateItem(request);
    }

    public Map<String, AttributeValue> getItem(String tableName, String key, String value) {
        GetItemRequest request = GetItemRequest.builder()
                .tableName(tableName)
                .key(Map.of(key, AttributeValue.builder().s(value).build()))
                .build();

        GetItemResponse response = dynamoDbClient.getItem(request);
        return response.item();
    }

    public List<Map<String, AttributeValue>> scanTable(String tableName) {
        ScanRequest scanRequest = ScanRequest.builder()
                .tableName(tableName)
                .build();

        ScanResponse response = dynamoDbClient.scan(scanRequest);
        return response.items();
    }
}
