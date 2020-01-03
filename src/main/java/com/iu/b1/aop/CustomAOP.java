package com.iu.b1.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CustomAOP {
	
	@Before("execution(* com.iu.b1.member.MemberService.memberLogin(..))")
	public void before() throws Exception{
		// 실행 전에 출력
		System.out.println("before memberJoin");
	}
	
	@AfterReturning("execution(* com.iu.b1.member.MemberService.memberLogin(..))")
	public void afterReturning() throws Exception{
		// 정상적으로 실행시 출력
		System.out.println("after Returning");
	}
	@AfterThrowing("execution(* com.iu.b1.member.MemberService.memberJoin(..))")
	public void afterThrowing() throws Exception{
		// 예외 발생시만 출력
		System.out.println("After Throwing");
	}
	@After("execution(* com.iu.b1.member.MemberService.memberJoin(..))")
	public void after() throws Exception{
		// 성공 여부 상관 없이 끝나면 출력
		System.out.println("After");
	}
	@Around("execution(* com.iu.b1.member.MemberService.memberLogin(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		// 전부 다 합친거
		System.out.println("메서드 실행 전");
		
		Object obj = joinPoint.proceed();
		
		System.out.println("메서드 실행 후");
		
		return obj;
	}
}
