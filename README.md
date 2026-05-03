## [Velog - 서버 환경 설정 정리](https://velog.io/@0verfl0w767/Spring-Boot-%EC%84%9C%EB%B2%84%EC%97%90-%EC%84%A4%EC%B9%98)


## Swagger API Documentation

- http://localhost:8080/swagger-ui/index.html

[//]: # ()
[//]: # (## Kakao Map Request &#40;Raw&#41;)

[//]: # ()
[//]: # (### REQUEST)

[//]: # (```http)

[//]: # (GET /api/kakao-map/search?q={검색어}&page={페이지})

[//]: # (```)

[//]: # ()
[//]: # (### RESPONSE)

[//]: # (```json)

[//]: # ([)

[//]: # (    {)

[//]: # (        "confirmid": "9924087",)

[//]: # (        "x": 513158,)

[//]: # (        "y": 1154198,)

[//]: # (        "lon": 127.05964235,)

[//]: # (        "lat": 37.65472958,)

[//]: # (        "name": "전민규의황제누룽지탕 노원직영점",)

[//]: # (        "tel": "02-937-0340",)

[//]: # (        "address": "서울 노원구 상계동 710-3 1-2층",)

[//]: # (        "reviewCount": 178,)

[//]: # (        "homepage": "",)

[//]: # (        "img": "http://t1.daumcdn.net/local/kakaomapPhoto/review/d2f4c04f2ffa34ac9557940a3b91c6e68cf3b907?original",)

[//]: # (        "sourceId": "",)

[//]: # (        "source": "",)

[//]: # (        "roadview": "1198397334|333|-6|||513172|1154167|2",)

[//]: # (        "full_category_ids": "9|124|728",)

[//]: # (        "last_cate_id": "728",)

[//]: # (        "last_cate_name": "해물,생선",)

[//]: # (        "last_cate_depth": "3",)

[//]: # (        "cate_name_depth1": "음식점",)

[//]: # (        "cate_name_depth2": "한식",)

[//]: # (        "cate_name_depth3": "해물,생선",)

[//]: # (        "cate_name_depth4": "",)

[//]: # (        "cate_name_depth5": "",)

[//]: # (        "hub_data": "",)

[//]: # (        "brand": "",)

[//]: # (        "brandName": "해물,생선",)

[//]: # (        "oil1": "0",)

[//]: # (        "oil2": "0",)

[//]: # (        "oil3": "0",)

[//]: # (        "oil4": "0",)

[//]: # (        "oilTime": "",)

[//]: # (        "oil_sel24": "",)

[//]: # (        "phoneSynonyms": "",)

[//]: # (        "related_place": "",)

[//]: # (        "new_address": "서울 노원구 노해로77길 14-8",)

[//]: # (        "courseinfo": "",)

[//]: # (        "geoinfo": "",)

[//]: # (        "requiringtime": "",)

[//]: # (        "tvshow_info": "",)

[//]: # (        "tvshow_name": "",)

[//]: # (        "address_disp": "서울|노원구|상계동|710-3|1-2층",)

[//]: # (        "new_address_disp": "서울|노원구||노해로77길|14-8|1-2층",)

[//]: # (        "distance": "646",)

[//]: # (        "catetype": "C",)

[//]: # (        "new_zipcode": "01689",)

[//]: # (        "openoff_status": "Y",)

[//]: # (        "shape_support_types": "",)

[//]: # (        "production_tags": [],)

[//]: # (        "rating_average": 3.0,)

[//]: # (        "rating_count": 73,)

[//]: # (        "addinfo_appointment": "Y",)

[//]: # (        "addinfo_delivery": "Y",)

[//]: # (        "addinfo_fordisabled": "Y",)

[//]: # (        "addinfo_nursery": "",)

[//]: # (        "addinfo_package": "Y",)

[//]: # (        "addinfo_parking": "Y",)

[//]: # (        "addinfo_pet": "N",)

[//]: # (        "addinfo_smokingroom": "",)

[//]: # (        "addinfo_wifi": "Y",)

[//]: # (        "cvs_lotto": "",)

[//]: # (        "cvs_medicine": "",)

[//]: # (        "cvs_parcel": "",)

[//]: # (        "cvs_withdrawal": "",)

[//]: # (        "meta_keywords_disp": "가족모임",)

[//]: # (        "issue_keywords_disp": "",)

[//]: # (        "pay_keywords_disp": "제로페이",)

[//]: # (        "oil_carwash": "",)

[//]: # (        "oil_convenience": "",)

[//]: # (        "oil_maintenance": "",)

[//]: # (        "oil_self": "",)

[//]: # (        "mobility_parking_exit_type": "",)

[//]: # (        "zigbang_info": null,)

[//]: # (        "display_restrict_type": "",)

[//]: # (        "display_name_info": {)

[//]: # (            "dp_name1": "전민규의",)

[//]: # (            "dp_name2": "황제누룽지탕")

[//]: # (        },)

[//]: # (        "knavi_guide_infos": [],)

[//]: # (        "bizconnect_info": [],)

[//]: # (        "bizprice_info": [],)

[//]: # (        "benefit_info": [],)

[//]: # (        "mystore_type": "N",)

[//]: # (        "yososu_info": null,)

[//]: # (        "indoor_info": null,)

[//]: # (        "addinfo_tag": "ADDINFO_PARKING;ADDINFO_FORDISABLED",)

[//]: # (        "first_hour_parking_fee": -1,)

[//]: # (        "image_info": {)

[//]: # (            "image_main_urls": [)

[//]: # (                "http://t1.daumcdn.net/local/kakaomapPhoto/review/d2f4c04f2ffa34ac9557940a3b91c6e68cf3b907?original",)

[//]: # (                "https://postfiles.pstatic.net/MjAyNjAzMjRfMTU0/MDAxNzc0MzMzNjEzNDM1.BhDLDUuVA-1WaT0lbM2jFZFpOU7br9CYVuGzN6WRMTwg.AY_DStnxRTh8O21sf2_1uL9SQA3truY8Um-PQMLrOsYg.JPEG/900%EF%BC%BF1774332831258.jpg?type=w386",)

[//]: # (                "https://postfiles.pstatic.net/MjAyNjAzMjNfMTc5/MDAxNzc0MjYwOTc1NjE5.bAgYr1yjFZ7MazB81yvic-6naBEBeMVm2-OvZqj2nGMg.3oaM4jVQFwO3h2e50bXa-f-_yN8BrogBbklkuTgwFVIg.JPEG/KakaoTalk_20260308_193231362_03.jpg?type=w466",)

[//]: # (                "https://postfiles.pstatic.net/MjAyNjAzMjNfMjU2/MDAxNzc0MjcwNjE0NTgz.mcZqyDaewyb_K_U94SXtrjmtmX3Fz1ono91vo5sdyEAg.sIIpPnPKq-t2sjpHcvcq5Ha0Y8UFMKm2o3zEFW-AkSQg.JPEG/SE-8acc7f9b-80ad-4170-a8fe-bfad85a1f339.jpg?type=w466",)

[//]: # (                "https://postfiles.pstatic.net/MjAyNjAzMDVfMjQy/MDAxNzcyNjc5MjkzODM1.vFDg0WsQHR0IPcG6Nv57bEEf4EaZzoeDloyW5V9SPScg.UxvrrLWnsizOL7pSB2jvVG-L5E-WsJegeF0IJsSFsyAg.JPEG/IMG%EF%BC%BF9045.JPG?type=w966",)

[//]: # (                "https://postfiles.pstatic.net/MjAyNjAzMTNfMTI0/MDAxNzczNDA0NTc0Mjcw.yNkXDZc8P9XvtIj9Md0jIZVhej1xV6M8Hni2l8E8fpUg.4C7iyShNdoc70l3KLYhhTW0WYSNmTSY7W6YXl_Zav_kg.JPEG/output%EF%BC%BF45469594.jpg?type=w386",)

[//]: # (                "https://postfiles.pstatic.net/MjAyNjAzMTNfMTMz/MDAxNzczNDA0Nzg0MzY0.QSKDhVziF70CbgbZOm8qtp1AMz--d7afGjUBZorqVvgg.7z6bC07N1WMMhucBq2SBlFLAbMDhq875NresY1Q1tsMg.JPEG/IMG%EF%BC%BF0858.JPG?type=w386",)

[//]: # (                "https://postfiles.pstatic.net/MjAyNjAzMTNfMTU5/MDAxNzczNDA0NTUzMTUx.0n1xSlUY6Z3coNoLWa0EwNaJM36oE8ItEzSioS3c_tsg.TxyZYRTRopM6xLwUza9vUpRhI5T6K4ZOjYFtMkI14lwg.JPEG/IMG%EF%BC%BF0831.JPG?type=w386",)

[//]: # (                "https://postfiles.pstatic.net/MjAyNjAzMTBfMTE3/MDAxNzczMTM5MjkzNjk3.fLEuPqqIzbNNvMFieov1bH4oYX1vBD_ce1XSm0gqh38g.voOvJ_6D8dkkJnJaLYVpUl4PHVjnNXw7Xs2a6zfThrEg.JPEG/900%EF%BC%BF1773139293402.jpg?type=w580",)

[//]: # (                "https://postfiles.pstatic.net/MjAyNjAzMTBfOSAg/MDAxNzczMTM5NTg3MDM5.Amf1v2NSyHOC94E_YlRy9emisO9c2LgxorSWrV6tFAAg.Cst-LJf_9rkLD7bUDLTc-8wu66UUhNUz_d9Ikc3-mlwg.JPEG/900%EF%BC%BF20260310%EF%BC%BF132512.jpg?type=w580")

[//]: # (            ],)

[//]: # (            "image_full_count": 1109,)

[//]: # (            "image_main_expose_count": 10)

[//]: # (        },)

[//]: # (        "is_new_open": "false",)

[//]: # (        "subway_line_id": "",)

[//]: # (        "talk_channel_id": null,)

[//]: # (        "train_types": [],)

[//]: # (        "evinfra_charger_info": null,)

[//]: # (        "mobility_charger_info": null,)

[//]: # (        "booking_addinfo": null,)

[//]: # (        "ad_track_id": "",)

[//]: # (        "has_free_parking": "",)

[//]: # (        "cs_reward_type": "",)

[//]: # (        "storeview_id": "0",)

[//]: # (        "grade_count": "0",)

[//]: # (        "kplace_ratings_count": "0",)

[//]: # (        "kplace_rating": "0")

[//]: # (    },)

[//]: # (    ...)

[//]: # (])

[//]: # (```)

[//]: # ()
[//]: # (## Naver Map Request &#40;Selenium&#41;)

[//]: # ()
[//]: # (### REQUEST)

[//]: # (```http)

[//]: # (GET /api/naver-map/search?q={검색어}&page={페이지})

[//]: # (```)

[//]: # ()
[//]: # (### RESPONSE)

[//]: # (```json)

[//]: # ([)

[//]: # (    {)

[//]: # (        "apolloCacheId": "20601566",)

[//]: # (        "coupon": null,)

[//]: # (        "id": "20601566",)

[//]: # (        "dbType": "drt",)

[//]: # (        "name": "쭈꾸미달인 노원본점",)

[//]: # (        "businessCategory": "restaurant",)

[//]: # (        "category": "주꾸미요리",)

[//]: # (        "description": null,)

[//]: # (        "hasBooking": null,)

[//]: # (        "hasNPay": false,)

[//]: # (        "x": "127.0629501",)

[//]: # (        "y": "37.6566219",)

[//]: # (        "distance": "400m",)

[//]: # (        "imageUrl": "https://ldb-phinf.pstatic.net/20150915_223/1442297117158VLJOL_JPEG/166865553532723_5.jpg",)

[//]: # (        "imageCount": 30,)

[//]: # (        "phone": null,)

[//]: # (        "virtualPhone": "0507-1358-3912",)

[//]: # (        "routeUrl": "http://map.naver.com/?eText=%EC%AD%88%EA%BE%B8%EB%AF%B8%EB%8B%AC%EC%9D%B8%20%EB%85%B8%EC%9B%90%EB%B3%B8%EC%A0%90&elng=127.0629501&elat=37.6566219",)

[//]: # (        "streetPanorama": {)

[//]: # (            "id": "JApN2PdWng+xTxFzi39+GA==",)

[//]: # (            "pan": "104.56",)

[//]: # (            "tilt": "30.00",)

[//]: # (            "lat": "37.6566938",)

[//]: # (            "lon": "127.0628738",)

[//]: # (            "__typename": "Panorama")

[//]: # (        },)

[//]: # (        "roadAddress": "상계로 71-1 1층",)

[//]: # (        "address": "상계동 595",)

[//]: # (        "commonAddress": "서울 노원구 상계동",)

[//]: # (        "blogCafeReviewCount": "1,039",)

[//]: # (        "bookingReviewCount": "0",)

[//]: # (        "totalReviewCount": "1,039",)

[//]: # (        "bookingUrl": null,)

[//]: # (        "bookingBusinessId": null,)

[//]: # (        "talktalkUrl": "http://talk.naver.com/wjp269t?frm=pnmb",)

[//]: # (        "detailCid": {)

[//]: # (            "c0": "220036/220037/220076/220802/231273",)

[//]: # (            "c1": "1004760/1004380/1002043",)

[//]: # (            "c2": null,)

[//]: # (            "c3": null,)

[//]: # (            "__typename": "DetailCid")

[//]: # (        },)

[//]: # (        "options": "포장,배달,예약,무선 인터넷,제로페이,지역화폐 &#40;카드형&#41;,지역화폐 &#40;모바일형&#41;,간편결제,주차",)

[//]: # (        "promotionTitle": null,)

[//]: # (        "agencyId": null,)

[//]: # (        "businessHours": null,)

[//]: # (        "newOpening": null,)

[//]: # (        "hasWheelchairEntrance": null,)

[//]: # (        "markerId": "231273",)

[//]: # (        "markerLabel": null,)

[//]: # (        "imageMarker": {)

[//]: # (            "marker": "nres://marker/00009-00071",)

[//]: # (            "markerSelected": "nres://marker/00009-00185",)

[//]: # (            "__typename": "ImageMarker")

[//]: # (        },)

[//]: # (        "__typename": "RestaurantListSummary",)

[//]: # (        "fullAddress": "서울특별시 노원구 상계동 595 1층",)

[//]: # (        "categoryCodeList": [)

[//]: # (            "220036",)

[//]: # (            "220037",)

[//]: # (            "220076",)

[//]: # (            "220802",)

[//]: # (            "231273")

[//]: # (        ],)

[//]: # (        "visitorReviewCount": "4,273",)

[//]: # (        "visitorReviewScore": "4.65",)

[//]: # (        "imageUrls": [)

[//]: # (            "https://ldb-phinf.pstatic.net/20150915_223/1442297117158VLJOL_JPEG/166865553532723_5.jpg",)

[//]: # (            "https://ldb-phinf.pstatic.net/20150915_231/1442297115121La6MB_JPEG/166865553532723_0.jpg")

[//]: # (        ],)

[//]: # (        "bookingHubUrl": null,)

[//]: # (        "bookingHubButtonName": null,)

[//]: # (        "visitorImages": [)

[//]: # (            {)

[//]: # (                "id": "mnbrtf4g0xop36ui8y8a",)

[//]: # (                "reviewId": "69c63c8296782b77468d82b9",)

[//]: # (                "imageUrl": "https://pup-review-phinf.pstatic.net/MjAyNjAzMjdfMTM0/MDAxNzc0NTk5Mjk2NDI1.Ab9RgMvyyZ2-SjYYBsY0iK0L1-RVRKFKmV6C9EV-Mj8g.jLJCQw6ZSwZnn6Rt6SSeXa75TZY390mjB7KHhsoSBoMg.JPEG/9FA818CB-6FBB-4C30-A846-52DEEEEBA318.jpeg",)

[//]: # (                "profileImageUrl": "",)

[//]: # (                "nickname": "dbs****",)

[//]: # (                "__typename": "VisitorImages")

[//]: # (            },)

[//]: # (            {)

[//]: # (                "id": "mnbrtf4gaabd55r046u",)

[//]: # (                "reviewId": "692ac4bbaf3285a006e01637",)

[//]: # (                "imageUrl": "https://pup-review-phinf.pstatic.net/MjAyNTExMjlfMTA0/MDAxNzY0NDEwNTUzMTE0.8Vqiex5ykNghv8l4ru5Sq1ZR2NvNqWJ20f80VfTFd_Ig.lIjs_ekyKsZWj4NDXlG4R7zUO6HEA5A1rl_ouZ4egqwg.JPEG/CC22BD4B-3242-4060-B704-5A1C393C7F5B.jpeg",)

[//]: # (                "profileImageUrl": "",)

[//]: # (                "nickname": "usagi16",)

[//]: # (                "__typename": "VisitorImages")

[//]: # (            },)

[//]: # (            {)

[//]: # (                "id": "mnbrtf4gshfzmhqcvim",)

[//]: # (                "reviewId": "69bb91482c10f5c5d6607f51",)

[//]: # (                "imageUrl": "https://pup-review-phinf.pstatic.net/MjAyNjAzMTlfMTc2/MDAxNzczOTAwMTAxNDIw.zadEVagSkoQKQEMjR9OxxrdlqxsBR1Vdl3Shz0OKOWMg.s7osm1FxhoethTW1cY6ZTgXKZmkvHAXPkEaKQeftDnQg.JPEG/E78719C5-07B8-437A-9E40-9C60D0A2D666.jpeg",)

[//]: # (                "profileImageUrl": "",)

[//]: # (                "nickname": "koh****",)

[//]: # (                "__typename": "VisitorImages")

[//]: # (            },)

[//]: # (            {)

[//]: # (                "id": "mnbrtf4g9w5w63cti39",)

[//]: # (                "reviewId": "694f9c6236fcd7e54581e755",)

[//]: # (                "imageUrl": "https://pup-review-phinf.pstatic.net/MjAyNTEyMjdfNTUg/MDAxNzY2ODI1MDU2Nzk1.SDi4s8PygCPznuv-n62dte19gZomHhdG0Q5LBM1btlog.Q9je72T95sDpOHei7EKe9NVQoyGTjNn5V64naKk-24kg.JPEG/25244C3E-58D9-4F5B-9F80-E0DDDF24A86B.jpeg",)

[//]: # (                "profileImageUrl": "",)

[//]: # (                "nickname": "jieu",)

[//]: # (                "__typename": "VisitorImages")

[//]: # (            },)

[//]: # (            {)

[//]: # (                "id": "mnbrtf4gfkqgma6s28d",)

[//]: # (                "reviewId": "68cbd6baefa342054f567c6d",)

[//]: # (                "imageUrl": "https://pup-review-phinf.pstatic.net/MjAyNTA5MThfMjc2/MDAxNzU4MTg5MjM5NTg3.GBkw1zOnJ0aeHfH9X2YGE43uRhnae7IH1JOGFdch0xYg.HXdb3hXnPR9LoR_KeR_a0b78xjcsAZ9cVmAngP9iD-wg.JPEG/1EEED620-957B-4178-A992-271569AAC4E8.jpeg",)

[//]: # (                "profileImageUrl": "",)

[//]: # (                "nickname": "뇽녱녕",)

[//]: # (                "__typename": "VisitorImages")

[//]: # (            })

[//]: # (        ],)

[//]: # (        "visitorReviews": [)

[//]: # (            {)

[//]: # (                "id": "mnbrtf4gz6qcw670ecj",)

[//]: # (                "review": "다먹고 <b>볶음밥</b>까지 <b>매운 </b>속을 달래줄 <b>계란찜 </b>숭늉에 콘버터까지. 글 쓰면서도 또가고싶어요.",)

[//]: # (                "reviewId": "69c20f11835fe23985d38d1b",)

[//]: # (                "__typename": "VisitorReviews")

[//]: # (            },)

[//]: # (            {)

[//]: # (                "id": "mnbrtf4g7bw8nylpnz",)

[//]: # (                "review": "벌써 몇 번째 방문인지 모를 정도로 제 찐 단골집이에요! 마지막에 <b>볶음밥</b>까지 꼭 필수로 먹어야해요!",)

[//]: # (                "reviewId": "69c5161c8ac522cb4f9e30d5",)

[//]: # (                "__typename": "VisitorReviews")

[//]: # (            },)

[//]: # (            {)

[//]: # (                "id": "mnbrtf4gy638wld8vp9",)

[//]: # (                "review": "친구들과 노원 나들이 왔다가 유명한 맛집이라고 해서 왔어요. <b>매콤한 </b>거 당길 때 또 올게요!",)

[//]: # (                "reviewId": "69c4a21e8ec9d4914ae7f179",)

[//]: # (                "__typename": "VisitorReviews")

[//]: # (            })

[//]: # (        ],)

[//]: # (        "foryouLabel": null,)

[//]: # (        "foryouTasteType": null,)

[//]: # (        "microReview": null,)

[//]: # (        "priceCategory": "2만원 대",)

[//]: # (        "broadcastInfo": null,)

[//]: # (        "michelinGuide": null,)

[//]: # (        "broadcasts": null,)

[//]: # (        "tvcastId": null,)

[//]: # (        "naverBookingCategory": null,)

[//]: # (        "saveCount": "5,000+",)

[//]: # (        "uniqueBroadcasts": null,)

[//]: # (        "naverOrder": {)

[//]: # (            "items": [],)

[//]: # (            "isDelivery": false,)

[//]: # (            "isTableOrder": false,)

[//]: # (            "isPreOrder": false,)

[//]: # (            "isPickup": false,)

[//]: # (            "__typename": "NaverOrder")

[//]: # (        },)

[//]: # (        "deliveryArea": null,)

[//]: # (        "isCvsDelivery": false,)

[//]: # (        "bookingDisplayName": "방문자 리뷰",)

[//]: # (        "bookingVisitId": null,)

[//]: # (        "bookingPickupId": null,)

[//]: # (        "popularMenuImages": null,)

[//]: # (        "newBusinessHours": {)

[//]: # (            "status": "영업 중",)

[//]: # (            "description": "23:00에 영업 종료",)

[//]: # (            "__typename": "NewBusinessHours")

[//]: # (        },)

[//]: # (        "baemin": null,)

[//]: # (        "yogiyo": null,)

[//]: # (        "realTimeBookingInfo": null,)

[//]: # (        "posInfo": {)

[//]: # (            "isPOS": true,)

[//]: # (            "items": [)

[//]: # (                {)

[//]: # (                    "value": "popularMenu",)

[//]: # (                    "title": "주간 인기 많은 메뉴",)

[//]: # (                    "description": "쭈꾸미삼겹살, 날치알 볶음밥, 매운쭈꾸미, 계란찜, 치즈날치알볶음밥",)

[//]: # (                    "__typename": "POSItem")

[//]: # (                },)

[//]: # (                {)

[//]: # (                    "value": "averagePrice",)

[//]: # (                    "title": "1회 결제 시 평균",)

[//]: # (                    "description": "밤 평균 45,714원대에요",)

[//]: # (                    "__typename": "POSItem")

[//]: # (                },)

[//]: # (                {)

[//]: # (                    "value": "stayTime",)

[//]: # (                    "title": "평균 체류 시간",)

[//]: # (                    "description": "보통 65분 머물러요",)

[//]: # (                    "__typename": "POSItem")

[//]: # (                })

[//]: # (            ],)

[//]: # (            "__typename": "POSInfo")

[//]: # (        },)

[//]: # (        "nPayConnect": null,)

[//]: # (        "membershipBenefit": null)

[//]: # (    },)

[//]: # (    ...)

[//]: # (])

[//]: # (```)
