package com.example.springbootlecture.common;

public class Response<T> {

    private final T data;  //Service에서 모든 정보를 받아와서 Response 할 것이기 때문에 final로 두기!

    public Response(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public static <T> Response<T> of(T data) {
        return new Response<> (data);
    }



}
