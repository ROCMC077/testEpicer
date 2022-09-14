<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>建立食譜</title>
    <style>
        .plus {
            border: 2px solid black;
        }
    </style>
</head>

<body>
 <%@include file="epicerNavbar.jsp"%>

    <h1>建立食譜</h1>
    <form action="addrecipe.controller" enctype="multipart/form-data" method="post" >
        <input type="hidden" name="todo" value="add">
        <div class="style-module__recipeEditorTitle___17c_g" id="name"><label
                class="mdc-text-field mdc-text-field--filled mdc-text-field--no-label mdc-ripple-upgraded"><input
                    class="mdc-text-field__input" type="text" name="title" placeholder="請填寫食譜標題" minlength="1"
                    required="" value="" style="width: 250px; height: 30px;"></label>

        </div>
        <div id="description">
            <h3 class="style-module__recipeEditorFieldTitle___1DFTn">簡介</h3>
            <div class="st1">
                <label for="" class="t1">照片</label>
                 <input type='file' name="file1"/>
                <img />
                <script src="https://code.jquery.com/jquery-3.1.0.js"></script>
                <script>
                    $('input').on('change', function (e) {
                        const file = this.files[0];

                        const fr = new FileReader();
                        fr.onload = function (e) {
                            $('img').attr('src', e.target.result);
                        };

                        // 使用 readAsDataURL 將圖片轉成 Base64
                        fr.readAsDataURL(file);
                    });
                </script>
            </div>
            <div class="style-module__recipeEditorTextArea___3FI8w"><label
                    class="mdc-text-field mdc-text-field--outlined mdc-text-field--textarea mdc-text-field--no-label style-module__recipeEditorTextAreaDom___2LZQF"><textarea
                        class="mdc-text-field__input" placeholder="輸入食譜描述 (最多 200 字)" name="description" rows="5"
                        style="width: 516px; height: 302px;"></textarea></span><span
                        class="mdc-notched-outline mdc-notched-outline--no-label"><span
                            class="mdc-notched-outline__leading"></span><span
                            class="mdc-notched-outline__trailing"></span></span></label>

            </div>
        </div>
        <div calss="howmany">

            <label for="" class="t1">份量:</label>
            <select name="howmanypeople" id="howmanypeople">
                <option value="null">未設定</option>
                <option value="1人份">1人份</option>
                <option value="2人份">2人份</option>
                <option value="3人份">3人份</option>
                <option value="4人份">4人份</option>
                <option value="5人份">5人份</option>
                <option value="6人份">6人份</option>
                <option value="7人份">7人份</option>
                <option value="8人份">8人份</option>
                <option value="9人份">9人份</option>
                <option value="10人份">10人份</option>
            </select>

        </div>
        <div calss="howlong">

            <label for="" class="t1">花費時間:</label>
            <select name="time" id="time">
                <option value="null">未設定</option>
                <option value="5分鐘">5分鐘</option>
                <option value="10分鐘">10分鐘</option>
                <option value="15分鐘">15分鐘</option>
                <option value="20分鐘">20分鐘</option>
                <option value="25分鐘">25分鐘</option>
                <option value="30分鐘">30分鐘</option>
                <option value="35分鐘">35分鐘</option>
                <option value="40分鐘">40分鐘</option>
                <option value="45分鐘">45分鐘</option>
                <option value="50分鐘">50分鐘</option>
                <option value="55分鐘">55分鐘</option>
                <option value="60分鐘">60分鐘</option>
            </select>

        </div>

        <section class="style-module__recipeEditorIngredient___23Kiz" id="ingredient">
            <h3 class="style-module__recipeEditorFieldTitle___1DFTn">食材<span
                    class="style-module__recipeEditorFieldTitleDescription___387Sr" aria-label="食材敘述">食材 15 字以內，份量 10
                    字以內</span></h3>

            <fieldset class="style-module__recipeEditorIngredientGroupContent___2RTSi">
                <div class="style-module__recipeEditorIngredientGroupContentRow___34M12" data-disabled-sortable="false"
                    aria-label="食材資訊"><label
                        class="mdc-text-field mdc-text-field--filled style-module__recipeEditorIngredientGroupContentRowName___1G1OJ mdc-text-field--no-label mdc-ripple-upgraded"><input
                            class="mdc-text-field__input" type="text" aria-label="食材" placeholder="食材" maxlength="15"
                            value="" name="ingredient"></label><label
                        class="mdc-text-field mdc-text-field--filled style-module__recipeEditorIngredientGroupContentRowQuantity___2pjzB mdc-text-field--no-label mdc-ripple-upgraded"><input
                            class="mdc-text-field__input" type="text" aria-label="份量" placeholder="份量" maxlength="10"
                            value="" name="amount"></label>
                </div>
                <div class="style-module__recipeEditorIngredientGroupContentRow___34M12" data-disabled-sortable="false"
                    aria-label="食材資訊"><label
                        class="mdc-text-field mdc-text-field--filled style-module__recipeEditorIngredientGroupContentRowName___1G1OJ mdc-text-field--no-label mdc-ripple-upgraded"><input
                            class="mdc-text-field__input" type="text" aria-label="食材" placeholder="食材" maxlength="15"
                            value="" name="ingredient"></label><label
                        class="mdc-text-field mdc-text-field--filled style-module__recipeEditorIngredientGroupContentRowQuantity___2pjzB mdc-text-field--no-label mdc-ripple-upgraded"><input
                            class="mdc-text-field__input" type="text" aria-label="份量" placeholder="份量" maxlength="10"
                            value="" name="amount"></label>

                </div>
            </fieldset><button
                class="mdc-button mdc-button--outlined style-module__recipeEditorIngredientGroupButtonAddIngredient___1AeYT"
                data-color="blue" data-size="md" data-full-width="true" data-unfulfilled="false" data-pending="false"
                id="plusing" data-with-title="false" type="button" aria-label="新增食材"><span
                    class="mdc-button__label">加入食材</span></button>

        </section>
        <section class="style-module__recipeEditorStep___3m52r" id="step">
            <h3 class="style-module__recipeEditorFieldTitle___1DFTn">步驟<span
                    class="style-module__recipeEditorFieldTitleDescription___387Sr" aria-label="步驟敘述"></span>
            </h3>
            <div class="steparea">
                <div class="style-module__recipeEditorStepItem___MuONW">

                    <section class="style-module__recipeEditorStepItemContent___1-QAn">
                        <header class="style-module__recipeEditorStepItemContentHeader___1BQMR">
                            <h4 class="style-module__recipeEditorStepItemContentHeaderTitle___RPJzS">1</h4>

                        </header>
                        <div class="style-module__recipeEditorTextArea___3FI8w"><label
                                class="mdc-text-field mdc-text-field--outlined mdc-text-field--textarea mdc-text-field--no-label style-module__recipeEditorTextAreaDom___2LZQF"><textarea
                                    class="mdc-text-field__input" placeholder="輸入步驟說明 (最多 150 字)" rows="4" name="step"
                                    style="width: 350px; height: 150px;"></textarea></span><span
                                    class="mdc-notched-outline mdc-notched-outline--no-label"><span
                                        class="mdc-notched-outline__leading"></span><span
                                        class="mdc-notched-outline__trailing"></span></span></label>

                        </div>
                    </section>
                </div>
                <div class="style-module__recipeEditorStepItem___MuONW">

                    <section class="style-module__recipeEditorStepItemContent___1-QAn">
                        <header class="style-module__recipeEditorStepItemContentHeader___1BQMR">
                            <h4 class="style-module__recipeEditorStepItemContentHeaderTitle___RPJzS">2</h4>

                        </header>
                        <div class="style-module__recipeEditorTextArea___3FI8w"><label
                                class="mdc-text-field mdc-text-field--outlined mdc-text-field--textarea mdc-text-field--no-label style-module__recipeEditorTextAreaDom___2LZQF"><textarea
                                    class="mdc-text-field__input" placeholder="輸入步驟說明 (最多 150 字)" rows="4" name="step"
                                    style="width: 350px; height: 150px;"></textarea></span><span
                                    class="mdc-notched-outline mdc-notched-outline--no-label"><span
                                        class="mdc-notched-outline__leading"></span><span
                                        class="mdc-notched-outline__trailing"></span></span></label>

                        </div>
                    </section>
                </div>
                <div class="style-module__recipeEditorStepItem___MuONW">

                    <section class="style-module__recipeEditorStepItemContent___1-QAn">
                        <header class="style-module__recipeEditorStepItemContentHeader___1BQMR">
                            <h4 class="style-module__recipeEditorStepItemContentHeaderTitle___RPJzS">3</h4>

                        </header>
                        <div class="style-module__recipeEditorTextArea___3FI8w"><label
                                class="mdc-text-field mdc-text-field--outlined mdc-text-field--textarea mdc-text-field--no-label style-module__recipeEditorTextAreaDom___2LZQF"><textarea
                                    class="mdc-text-field__input" placeholder="輸入步驟說明 (最多 150 字)" rows="4" name="step"
                                    style="width: 350px; height: 150px;"></textarea></span><span
                                    class="mdc-notched-outline mdc-notched-outline--no-label"><span
                                        class="mdc-notched-outline__leading"></span><span
                                        class="mdc-notched-outline__trailing"></span></span></label>
                        </div>
                    </section>
                </div>
            </div>
            <label class="plus">增加步驟</label>
        </section>
        <div class="sub">
            <input type="submit" value="送出">
            <input type="reset" value="清除">
        </div>
    </form>
    <script src="https://code.jquery.com/jquery-3.6.0.js"
        integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script>
        $(function () {
            $('#plusing').click(function () {
                let content = `
    <div class="style-module__recipeEditorIngredientGroupContentRow___34M12" data-disabled-sortable="false"
                    aria-label="食材資訊"><label
                        class="mdc-text-field mdc-text-field--filled style-module__recipeEditorIngredientGroupContentRowName___1G1OJ mdc-text-field--no-label mdc-ripple-upgraded"><input
                            class="mdc-text-field__input" type="text" aria-label="食材" placeholder="食材" maxlength="15"
                            value="" name="ingredient"></label><label
                        class="mdc-text-field mdc-text-field--filled style-module__recipeEditorIngredientGroupContentRowQuantity___2pjzB mdc-text-field--no-label mdc-ripple-upgraded"><input
                            class="mdc-text-field__input" type="text" aria-label="份量" placeholder="份量" maxlength="10"
                            value="" name="amount"></label>
                            </div>
                            `
                $('.style-module__recipeEditorIngredientGroupContent___2RTSi').append(content)
            })
            let i = 4
            $('.plus').click(function () {

                let content =
                    `<div class="style-module__recipeEditorStepItem___MuONW">

<section class="style-module__recipeEditorStepItemContent___1-QAn">
    <header class="style-module__recipeEditorStepItemContentHeader___1BQMR">
        <h4 class="style-module__recipeEditorStepItemContentHeaderTitle___RPJzS">`+ i + `</h4>

    </header>
    <div class="style-module__recipeEditorTextArea___3FI8w"><label
            class="mdc-text-field mdc-text-field--outlined mdc-text-field--textarea mdc-text-field--no-label style-module__recipeEditorTextAreaDom___2LZQF"><textarea
                class="mdc-text-field__input" placeholder="輸入步驟說明 (最多 150 字)" rows="4" name="step"
                style="width: 350px; height: 150px;"></textarea></span><span
                class="mdc-notched-outline mdc-notched-outline--no-label"><span
                    class="mdc-notched-outline__leading"></span><span
                    class="mdc-notched-outline__trailing"></span></span></label>
    </div>
</section>
</div>
    `
                $('.steparea').append(content)
                i++
            })




        })
    </script>
    
</body>

</html>