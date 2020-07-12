package com.learn.enumeration;

public enum StatusCode {
    OK(200,"请求成功"),
    MOVED_PERMANENTLY(301,"被请求的资源已永久移动到新位置"),
    BAD_REQUEST(400,"错误的请求"),
    UNAUTHORIZED(401,"未授权的请求"),
    FORBIDDEN(403,"请求的资源不允许访问，即没有权限"),
    NOT_FOUND(404,"请求的内容不存在"),
    METHOD_NOT_ALLOWED(405,"不允许此方法"),
    UNSUPPORTED_MEDIA_TYPE(415,"不支持的MIME类型"),
    INTERNAL_SERVER_ERROR(500,"服务器内部错误"),
    NOT_IMPLEMENTED(501,"请求没有被实现"),
    BAD_GATEWAY(502,"网关出错"),
    SERVICE_UNAVAILABLE(503,"服务暂时不可用"),
    HTTP_VERSION_NOT_SUPPORTED(505,"请求的http版本不支持");

    final int code;
    final String description;
    StatusCode(int code, String description){
        this.code=code;
        this.description=description;
    }
    public int getCode(){
        return this.code;
    }
    public String getDescription(){
        return this.description;
    }
}
