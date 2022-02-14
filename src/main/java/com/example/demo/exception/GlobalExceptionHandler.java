package com.example.demo.exception;

import com.example.demo.common.ErrorBody;
import com.example.demo.exception.custom.CustomSqlException;
import com.example.demo.exception.custom.CustomValidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /* @valid 에러 핸들링 */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorBody> handleValidException(MethodArgumentNotValidException e) {
        log.info("valid error");
        log.info(e.getMessage());

        return ResponseEntity.ok().body(
                ErrorBody.builder()
                        .message(e.getMessage())
                        .code(HttpStatus.BAD_REQUEST.value())
                        .build());
    }

    /* @valid 검증 후, 서비스 로직내의 유효성 검증 에러 */
    @ExceptionHandler(CustomValidException.class)
    protected ResponseEntity<ErrorBody> handleCustomValidException(CustomValidException e) {
        log.info("custom valid error");
        log.info(e.getMessage());

        return ResponseEntity.ok().body(
                ErrorBody.builder()
                        .message(e.getMessage())
                        .code(HttpStatus.BAD_REQUEST.value())
                        .build());
    }

    /* sql 에러 */
    @ExceptionHandler(SQLException.class)
    protected ResponseEntity<ErrorBody> handleSqlException(SQLException e){
        log.info("sql error");
        log.info(e.getMessage());

        return ResponseEntity.ok().body(
                ErrorBody.builder()
                        .message(e.getMessage())
                        .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .build());
    }

    /* custom sql 에러 */
    /* 정상적으로 sql 실행되었지만, 논리적으로 맞지않을때 사용 */
    @ExceptionHandler(CustomSqlException.class)
    protected ResponseEntity<ErrorBody> handleCustomSqlException(CustomSqlException e){
        log.info("custom sql error");
        log.info(e.getMessage());

        return ResponseEntity.ok().body(
                ErrorBody.builder()
                        .message(e.getMessage())
                        .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .build());
    }

    /* 나머지 에러 */
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorBody> handleException(Exception e) {
        log.info("server error");
        log.info(e.getMessage());

        return ResponseEntity.ok().body(
                ErrorBody.builder()
                        .message(e.getMessage())
                        .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .build());
    }
}