package com.cts.aspect;
 
import com.cts.entity.AuditLog;
import com.cts.repository.AuditLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
 
import java.time.Instant;
import java.util.Arrays;
 
@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class AuditAspect {
 
    private final AuditLogRepository auditLogRepository;
 
    @AfterReturning(
        pointcut = "execution(* com.cts.service.*.create*(..)) || " +
                   "execution(* com.cts.service.*.update*(..)) || " +
                   "execution(* com.cts.service.*.delete*(..))"
    )
    public void auditDbLogs(JoinPoint joinPoint) {
 
        String methodName = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();
 
       
        String performedBy = getCurrentUserEmail();
 
        AuditLog logEntity = AuditLog.builder()
                .action(resolveAction(methodName))
                .entityName(joinPoint.getTarget().getClass().getSimpleName())
                .methodName(methodName)
                .performedBy(performedBy)
                .details(Arrays.toString(args))
                .performedAt(Instant.now())
                .build();
 
        auditLogRepository.save(logEntity);
 
        log.info("AUDIT SAVED TO DB: {}", logEntity.getAction());
    }
 
    private String resolveAction(String methodName) {
        if (methodName.contains("create")) return "CREATE";
        if (methodName.contains("update")) return "UPDATE";
        if (methodName.contains("delete")) return "DELETE";
        return "OTHER";
    }
 
    private String getCurrentUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return "UNKNOWN";
        }
        return authentication.getName();
    }
}
 