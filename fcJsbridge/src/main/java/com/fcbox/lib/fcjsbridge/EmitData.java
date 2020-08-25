package com.fcbox.lib.fcjsbridge;

/**
 * @创建者 003099
 * @创建时间 2020/7/8 13:54
 * @描述 提交数据到web
 */
public class EmitData<T> {
    //"{\"status\":0,\"msg\":\"success\",\"data\":\"xxx\"}"

    private int status = 0;

    private boolean success = true;

    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "EmitData{" +
                "status=" + status +
                ", success=" + success +
                ", data=" + data +
                '}';
    }
}
