package neocore;

public class JsonTest {
    private String[] userIds;
    private String idempotencyKey;


    @Override
    public String toString() {
        return "{" +
                "idempotencyKey='" + idempotencyKey + '\'';
    }

    public JsonTest(String[] userIds, String idempotencyKey) {
        this.userIds = userIds;
        this.idempotencyKey = idempotencyKey;
    }

    public String[] getUserIds() {
        return userIds;
    }
    public void setUserIds(String[] userIds) {
        this.userIds = userIds;
    }
    public String getIdempotencyKey() {
        return idempotencyKey;
    }
    public void setIdempotencyKey(String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
    }
}
