import 'package:diary_app/src/api/challenge_api.dart';
import 'package:diary_app/src/model/challenge.dart';
import 'package:flutter/cupertino.dart';

class ChallengeProvider extends ChangeNotifier{

  ChallengeAPI _challengeAPI = ChallengeAPI();
  List<Challenge> _challenges = [];

  List<Challenge> get challenges => _challenges;

  loadChallenges(String uuid) async {
    List<Challenge> ChallengeList = await _challengeAPI.requestChallengeListToSpring(uuid); // 여기서 리턴값을 못 받고 있을.
    _challenges = ChallengeList;
    notifyListeners();
  }

  clearChallenges() {
    _challenges.clear();
  }
}
