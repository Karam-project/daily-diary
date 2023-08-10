import 'dart:convert';
import 'package:diary_app/src/model/api_message.dart';
import 'package:diary_app/src/model/challenge.dart';
import 'package:http/http.dart' as http;
import 'package:flutter/material.dart';

class ChallengeAPI {
  static const httpUri = 'user ip: port';

  requestRegisterChallengeToSpring(name, adid, uuid) async {
    var data = {
      'name': name,
      'adid': adid,
      'uuid': uuid
    };
    var body = json.encode(data);
    try {
      var requestRegisterChallengeResponse = await http.post(
        Uri.http(httpUri, 'daily-diary/challenge/register'),
        headers: {"Content-Type": "application/json"},
        body: body,
      );

      debugPrint(requestRegisterChallengeResponse.statusCode.toString());
      if (requestRegisterChallengeResponse.statusCode == 200) {
        debugPrint("챌린지 등록 결과 : " +
            utf8.decode(requestRegisterChallengeResponse.bodyBytes).toString());
        APIMessage.msg= utf8.decode(requestRegisterChallengeResponse.bodyBytes).toString();

      }
    } catch (e) {
      debugPrint("오류 발생 " + e.toString());
    }
  }

  //getMapping - requestParam 방식
  requestChallengeListToSpring(Uuid) async {

    var uuid = json.encode(Uuid);
    Map<String, String> param = {"Content-Type": "application/json", "uuid": uuid};

    debugPrint("나의 챌린지리스트 조회: 유유아이디 "+uuid);
    try {
      var requestChallengeListResponse = await http.get(
        Uri.http(httpUri, 'daily-diary/challenge/', param)
      );

      debugPrint(requestChallengeListResponse.statusCode.toString());

      if (requestChallengeListResponse.statusCode == 200) {
        debugPrint("챌린지 리스트 조회 결과 : " +
            utf8.decode(requestChallengeListResponse.bodyBytes).toString());

        if (requestChallengeListResponse.body != null) {
          return challengeFromJson(requestChallengeListResponse.body);
        }

      }
    } catch (e) {
      debugPrint("오류 발생 " + e.toString());
    }
  }

}
