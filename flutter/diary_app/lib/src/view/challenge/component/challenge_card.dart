
import 'package:flutter/material.dart';

class ChallengeCard extends StatelessWidget{
  const ChallengeCard({Key? key,
    required this.challengeId,
    required this.challengeName,
    required this.startDate,
    required this.onTap,
    }) : super(key: key);

  final int challengeId;
  final String challengeName;
  final DateTime startDate;
  final VoidCallback onTap;

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: onTap,
      child: Container(
        width: MediaQuery.of(context).size.width * 0.8,
          padding: EdgeInsets.only(left: 30, right: 20, top: 30, bottom: 30),
          margin:  EdgeInsets.symmetric(vertical: 15),
          decoration: BoxDecoration(
              border:Border.all(
                  width:1,
                  color: Colors.grey.shade400
              ),
              borderRadius: BorderRadius.all(
                  Radius.circular(20)
              )
          ),
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                   Text('${challengeName}', style:
                     TextStyle(
                       fontSize: 20
                     )),
                   SizedBox(height: 10,),
                   Text('${startDate} ~ '),
                ],
              ),
              Column(
                children: [
                  Icon(Icons.navigate_next, color: Colors.grey.shade400,)
                ],
              )
            ],
          ),
      ),
      // onTap:, challengeId
      //클릭 이벤트
    );
  }
}