using FluentAssertions;



using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Firefox;

namespace Selenium1
{
    public class Tests
    {



        private ChromeDriver _driver;
        private FirefoxDriver _driver1;

        [SetUp]
        public void Setup()
        {
            _driver = new ChromeDriver("C:\\Users\\Wezu\\source\\repos\\TAU");
             _driver1 = new FirefoxDriver("C:\\Users\\Wezu\\source\\repos\\TAU");
            
        }



        [TearDown]
        public void Teardown()
        {
            _driver.Close();
            _driver1.Close();
        }



        [Test]
        public void Test1()
        {
            _driver.Url = "https://www.armyworld.pl/";
            _driver.Manage().Window.Maximize();

            //accept cookies
            IWebElement Cookies = _driver.FindElement(By.CssSelector("#ckdsclmrshtdwn_v2 > span"));
            Cookies.Click();
            //go to login
            IWebElement GoToLogin = _driver.FindElement(By.CssSelector("#menu_additional > a"));
            GoToLogin.Click();
            //write mail
            IWebElement Mail = _driver.FindElement(By.CssSelector("#user_login"));
            Mail.SendKeys("test@mail.pl");
            // write password
            IWebElement WritePassword = _driver.FindElement(By.CssSelector("#user_pass"));
            WritePassword.SendKeys("Password");

            //click submit
            IWebElement ClickSubmit = _driver.FindElement(By.CssSelector("#signin-form_box_sub_1 > form > div.signin_buttons.col-md-10.col-12 > button"));
            ClickSubmit.Click();

            //check if error is seen
            IWebElement CheckErrror = _driver.FindElement(By.CssSelector("#return_sub_account_badlogin > h3"));
            Assert.IsNotNull(CheckErrror);

        }


        [Test]
        public void Test2()
        {
            _driver.Url = "https://www.armyworld.pl/";
            _driver.Manage().Window.Maximize();

            //accept cookies
            IWebElement Cookies = _driver.FindElement(By.CssSelector("#ckdsclmrshtdwn_v2 > span"));
            Cookies.Click();
            //go to tools
            IWebElement Tools = _driver.FindElement(By.CssSelector("#menu_navbar > ul > li:nth-child(3) > a"));
            Tools.Click();
            //chose etui
            IWebElement Etui = _driver.FindElement(By.CssSelector("#search > div:nth-child(2) > a > picture > img"));
            Etui.Click();
            //add etui to basket
            IWebElement AddToBasket = _driver.FindElement(By.CssSelector("#projector_button_basket"));
            AddToBasket.Click();
            // go to basket
            IWebElement GoToBasket = _driver.FindElement(By.CssSelector("#menu_preloader_add > div > div > div.added__buttons.justify-content-center.align-items-center > a.added__button.--basket.btn.--solid.--medium"));
            GoToBasket.Click();

            //check that the number in basket is 1
            IWebElement checkingBasket = _driver.FindElement(By.CssSelector("#menu_basket > a > span"));
            Assert.IsNotNull(checkingBasket);
         

         
        }

        [Test]
        public void Test3()
        {
            _driver1.Url = "https://www.lidl.pl/";
            _driver1.Manage().Window.Maximize();

            //go to workshop and  car
            IWebElement Workshop = _driver1.FindElement(By.CssSelector("div.n-header__list:nth-child(6) > div:nth-child(1) > div:nth-child(1) > ol:nth-child(3) > li:nth-child(5) > a:nth-child(1) > span:nth-child(1)"));
            Workshop.Click();
            //go to power tools
            IWebElement PowerTools = _driver1.FindElement(By.CssSelector("ul.s-facet__list:nth-child(2) > li:nth-child(1) > div:nth-child(1) > a:nth-child(1) > span:nth-child(1)"));
            PowerTools.Click();
            //chose opalarka
            IWebElement Opalarka = _driver1.FindElement(By.CssSelector("#product_1 > div:nth-child(1) > a:nth-child(1)"));
            Opalarka.Click();
            //add opalarka to basket
            IWebElement AddToBasket = _driver1.FindElement(By.CssSelector("#addToCart"));
            AddToBasket.Click();
            // continue shoping
            IWebElement ContinueShoping = _driver1.FindElement(By.CssSelector("button.otc-cart-flyout__button--continue-shopping:nth-child(2)"));
            ContinueShoping.Click();

            //check that the number in basket is 1
            IWebElement CheckBasket = _driver1.FindElement(By.CssSelector(".m-icon--shopping-cartn"));
            Assert.IsNotNull(CheckBasket);



        }
        [Test]
        public void Test4()
        {
            _driver1.Url = "https://www.lidl.pl/";
            _driver1.Manage().Window.Maximize();

            //go to login
            IWebElement GoToLogin1 = _driver1.FindElement(By.CssSelector(".m-icon--user"));
            GoToLogin1.Click();

            IWebElement WriteLogin = _driver1.FindElement(By.CssSelector("#field_EmailOrPhone"));
            WriteLogin.SendKeys("test@wp.pl");
            //write mail
         
       
            //click submit
            IWebElement ClickSubmit = _driver1.FindElement(By.CssSelector("#button_btn_submit_email"));
            ClickSubmit.Click();

            //check if error is seen
            IWebElement CheckErrror1 = _driver1.FindElement(By.CssSelector(".error_EmailOrPhone"));
            Assert.IsNotNull(CheckErrror1);


        }
    }
}