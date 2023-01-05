<!DOCTYPE html>
<html lang="hu">
<head>
	<meta charset="UTF-8">
	<title>FatherFood</title>
	<link rel="stylesheet" href="res/style.css">
</head>
<body>

	<header>
        <div id="welcome">Üdvözlünk az éttermünkben!</div>
    </header>
	
    <nav>
        <ul>
            
            <li><a href="index.html">Főoldal</a></li>
            <li></li>
            <li><a href="menu.html">Étlap</a></li>
            <li></li>
            <li><a href="desk.php">Asztal foglalás</a></li>
            <li></li>
            <li><a href="about.html">Kapcsolat</a></li>
        </ul>
    </nav>

    <div class="container">
        <main>

            <h1>Foglalj asztalt!</h1>
            <center>
            <form action="controller.java" method="post">
                <div id="desk-container">
                    <div class="booking">
                        <label for="name">Neve:</label>
                        <input type="text" name="name" id="1" required>
                    </div>
                    <div class="booking">
                        <label for="email">e-Mail:</label>
                        <input type="text" name="email" id="2" required>
                    </div>
                    <div class="booking">
                        <label for="phone">Telefonszám:</label>
                        <input type="text" name="phone" id="3" required>
                    </div>
                </div>
                <div>
                    <label for="desk-type">Asztal méret:</label>
                    <select name="desk-type" id="4" required>
                        <option value="two">Kétszemélyes</option>
                        <option value="three">Háromszemélyes</option>
                        <option value="four">Négyszemélyes</option>
                    </select>
                </div>
                    <?php
                    <table>
                        <tr>
                            <td>8:00-9:00 <input type="checkbox" name="" id="5"></td>
                            <td>9:00-10:00 <input type="checkbox" name="" id="6"></td>
                            <td>10:00-11:00 <input type="checkbox" name="" id="7"></td>
                            <td>11:00-12:00 <input type="checkbox" name="" id="8"></td>
                        </tr>
                        <tr>
                            <td>12:00-13:00 <input type="checkbox" name="" id="9"></td>
                            <td>13:00-14:00 <input type="checkbox" name="" id="10"></td>
                            <td>14:00-15:00 <input type="checkbox" name="" id="11"></td>
                            <td>15:00-16:00 <input type="checkbox" name="" id="12"></td>
                        </tr>
                        <tr>
                            <td class="menu-no-border">16:00-17:00 <input type="checkbox" name="" id="13"></td>
                            <td class="menu-no-border">17:00-18:00 <input type="checkbox" name="" id="14"></td>
                            <td class="menu-no-border">18:00-19:00 <input type="checkbox" name="" id="15"></td>
                            <td class="menu-no-border">19:00-20:00 <input type="checkbox" name="" id="16"></td>
                        </tr>
                    </table>
                    ?>
                    <input type="submit" value="Küldés">
                </center>
            </form>
        </main>
        <aside>

            <section>
                <h3>Lorem ipsum</h3>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Laborum deleniti sunt pariatur eligendi itaque laboriosam.</p>
            </section>
            
            <section>
                <h3>Lorem ipsum</h3>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Laborum deleniti sunt pariatur eligendi itaque laboriosam.</p>
            </section>

        </aside>
    </div>

</body>
</html>