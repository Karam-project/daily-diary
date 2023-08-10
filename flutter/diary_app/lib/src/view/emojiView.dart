import 'package:flutter/material.dart';

class EmojiView extends StatelessWidget {
  const EmojiView({
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        SizedBox(
          height: 100,
        ),
        Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: [
            Image.asset("assets/images/emoji/bigsmile.png",
              width: 70,
              height: 70,
              // fit: BoxFit.fill,
            ),
            Image.asset("assets/images/emoji/smile.png",
              width: 70,
              height: 70,),
            Image.asset("assets/images/emoji/soso.png",
              width: 70,
              height: 70,),
            Image.asset("assets/images/emoji/sad.png",
              width: 70,
              height: 70,),
            Image.asset("assets/images/emoji/sosad.png",
              width: 70,
              height: 70,),
          ],
        ),
      ],
    );
  }
}