package com.cts.dto.response;
import com.cts.enums.Sex;
import com.cts.enums.AuditAction;
import lombok.*;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DispatcherResponse {

    private Long dispatcherId;
    private String name;
    private String email;
    private String phone;
    private String emergencyContact;
    private String address;
    private String bloodGroup;
    private AuditAction status;
    private Sex sex;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}