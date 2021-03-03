# java-blackjack

블랙잭 게임 미션 저장소

## 우아한테크코스 코드리뷰

* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

### 기능 구현 목록

- [x] 플레이어 이름을 쉼표 기준으로 분리해서 입력 받는다.
    - [x] 쉼표로 분리 후 양쪽 공백을 제거
    - [x] [예외] 참가자 이름 중복 없어야 한다.
    - [x] [예외] 양쪽 공백을 제외한 이름의 글자 수가 1글자 이상이어야 한다.
- [x] 블랙잭에 사용할 52장의 카드들로 이루어진 카드덱을 생성한다.
    - [x] 카드덱 생성 후 셔플한다.
- [x] 플레이어와 딜러에게 카드를 2장씩 지급한다.
- [x] 플레이어의 카드 합이 21 미만일 경우, 카드를 더 받을 지 물어본다.
    - [x] y를 입력할 경우, 카드를 추가로 지급
    - [x] n을 입력할 경우, 다음 플레이어에게 카드를 더 받을 지 물어본다.
    - [x] 카드 합이 21을 초과할 경우, 카드를 더 받을 지 그만 물어본다.
    - [x] 참가자가 가지고 있는 카드 합을 구하는 기능
    - [x] ACE를 상황에 따라 1 또는 11로 변환하는 기능
- [x] 딜러의 카드 합이 16 이하일 경우, 카드를 추가로 1장 더 받는다.
- [ ] 딜러와 플레이어들의 카드 정보와 결과 숫자를 출력한다.
- [ ] 최종 승패를 출력한다.
    - [ ] 딜러는 승패의 수를 출력
    - [ ] 플레이어는 승패여부만 출력
    - [ ] 플레이어와 딜러의 승패 여부를 따진다.
        - [x] 둘 다 21을 초과하지 않을 경우, 21에 가까운 수를 만드는 쪽이 이긴다.
        - [ ] 둘 중 하나가 21을 초과할 경우, 21을 초과하지 않는 쪽이 이긴다.
        - [ ] 둘 다 21을 초과할 경우, 딜러의 승리 (플레이어의 패배)
        - [ ] 둘 다 숫자의 합이 같을 경우, 무승부
