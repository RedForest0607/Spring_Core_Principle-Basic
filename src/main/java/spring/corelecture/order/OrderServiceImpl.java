package spring.corelecture.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.corelecture.discount.DiscountPolicy;
import spring.corelecture.discount.FixDiscountPolicy;
import spring.corelecture.discount.RateDiscountPolicy;
import spring.corelecture.member.Member;
import spring.corelecture.member.MemberRepository;
import spring.corelecture.member.MemoryMemberRepository;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

//    테스트 용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
