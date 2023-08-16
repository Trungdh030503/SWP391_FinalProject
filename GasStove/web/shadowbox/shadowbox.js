!function(a, b) {
    function p() {
        for (var d, f, g, h, i, j, k, l, a = c.errorInfo, b = c.plugins, m = 0; m < c.gallery.length; ++m) {
            switch (d = c.gallery[m],
            f = !1,
            g = null,
            d.player) {
            case "flv":
            case "swf":
                b.fla || (g = "fla");
                break;
            case "qt":
                b.qt || (g = "qt");
                break;
            case "wmp":
                c.isMac ? b.qt && b.f4m ? d.player = "qt" : g = "qtf4m" : b.wmp || (g = "wmp");
                break;
            case "qtwmp":
                b.qt ? d.player = "qt" : b.wmp ? d.player = "wmp" : g = "qtwmp"
            }
            if (g)
                if ("link" == c.options.handleUnsupported) {
                    switch (g) {
                    case "qtf4m":
                        i = "shared",
                        j = [a.qt.url, a.qt.name, a.f4m.url, a.f4m.name];
                        break;
                    case "qtwmp":
                        i = "either",
                        j = [a.qt.url, a.qt.name, a.wmp.url, a.wmp.name];
                        break;
                    default:
                        i = "single",
                        j = [a[g].url, a[g].name]
                    }
                    d.player = "html",
                    d.content = '<div class="sb-message">' + z(c.lang.errors[i], j) + "</div>"
                } else
                    f = !0;
            else
                "inline" == d.player ? (h = e.exec(d.content),
                h ? (k = B(h[1]),
                k ? d.content = k.innerHTML : f = !0) : f = !0) : "swf" != d.player && "flv" != d.player || (l = d.options && d.options.flashVersion || c.options.flashVersion,
                c.flash && !c.flash.hasFlashPlayerVersion(l) && (d.width = 310,
                d.height = 177));
            f && (c.gallery.splice(m, 1),
            m < c.current ? --c.current : m == c.current && (c.current = m > 0 ? m - 1 : m),
            --m)
        }
    }
    function q(a) {
        c.options.enableKeys && (a ? K : L)(document, "keydown", r)
    }
    function r(a) {
        if (!(a.metaKey || a.shiftKey || a.altKey || a.ctrlKey)) {
            var d, b = J(a);
            switch (b) {
            case 81:
            case 88:
            case 27:
                d = c.close;
                break;
            case 37:
                d = c.previous;
                break;
            case 39:
                d = c.next;
                break;
            case 32:
                d = "number" == typeof o ? c.pause : c.play
            }
            d && (I(a),
            d())
        }
    }
    function s(a) {
        q(!1);
        var b = c.getCurrent()
          , d = "inline" == b.player ? "html" : b.player;
        if ("function" != typeof c[d])
            throw "unknown player " + d;
        if (a && (c.player.remove(),
        c.revertOptions(),
        c.applyOptions(b.options || {})),
        c.player = new c[d](b,c.playerId),
        c.gallery.length > 1) {
            var e = c.gallery[c.current + 1] || c.gallery[0];
            if ("img" == e.player) {
                var f = new Image;
                f.src = e.content
            }
            var g = c.gallery[c.current - 1] || c.gallery[c.gallery.length - 1];
            if ("img" == g.player) {
                var h = new Image;
                h.src = g.content
            }
        }
        c.skin.onLoad(a, t)
    }
    function t() {
        if (j)
            if ("undefined" != typeof c.player.ready)
                var a = setInterval(function() {
                    j ? c.player.ready && (clearInterval(a),
                    a = null,
                    c.skin.onReady(u)) : (clearInterval(a),
                    a = null)
                }, 10);
            else
                c.skin.onReady(u)
    }
    function u() {
        j && (c.player.append(c.skin.body, c.dimensions),
        c.skin.onShow(v))
    }
    function v() {
        j && (c.player.onLoad && c.player.onLoad(),
        c.options.onFinish(c.getCurrent()),
        c.isPaused() || c.play(),
        q(!0))
    }
    function w() {
        return (new Date).getTime()
    }
    function x(a, b) {
        for (var c in b)
            a[c] = b[c];
        return a
    }
    function y(a, b) {
        for (var c = 0, d = a.length, e = a[0]; c < d && b.call(e, c, e) !== !1; e = a[++c])
            ;
    }
    function z(a, b) {
        return a.replace(/\{(\w+?)\}/g, function(a, c) {
            return b[c]
        })
    }
    function A() {}
    function B(a) {
        return document.getElementById(a)
    }
    function C(a) {
        a.parentNode.removeChild(a)
    }
    function F() {
        var a = document.body
          , b = document.createElement("div");
        D = "string" == typeof b.style.opacity,
        b.style.position = "fixed",
        b.style.margin = 0,
        b.style.top = "20px",
        a.appendChild(b, a.firstChild),
        E = 20 == b.offsetTop,
        a.removeChild(b)
    }
    function H(a) {
        return [a.pageX, a.pageY]
    }
    function I(a) {
        a.preventDefault()
    }
    function J(a) {
        return a.keyCode
    }
    function K(a, b, c) {
        jQuery(a).bind(b, c)
    }
    function L(a, b, c) {
        jQuery(a).unbind(b, c)
    }
    function O() {
        if (!M) {
            try {
                document.documentElement.doScroll("left")
            } catch (a) {
                return void setTimeout(O, 1)
            }
            c.load()
        }
    }
    function P() {
        if ("complete" === document.readyState)
            return c.load();
        if (document.addEventListener)
            document.addEventListener("DOMContentLoaded", N, !1),
            a.addEventListener("load", c.load, !1);
        else if (document.attachEvent) {
            document.attachEvent("onreadystatechange", N),
            a.attachEvent("onload", c.load);
            var b = !1;
            try {
                b = null === a.frameElement
            } catch (a) {}
            document.documentElement.doScroll && b && O()
        }
    }
    function W(a) {
        c.open(this),
        c.gallery.length && I(a)
    }
    function aa() {
        Z = {
            x: 0,
            y: 0,
            startX: null,
            startY: null
        }
    }
    function ba() {
        var a = c.dimensions;
        x($.style, {
            height: a.innerHeight + "px",
            width: a.innerWidth + "px"
        })
    }
    function ca() {
        aa();
        var a = ["position:absolute", "cursor:" + (c.isGecko ? "-moz-grab" : "move"), "background-color:" + (c.isIE ? "#fff;filter:alpha(opacity=0)" : "transparent")].join(";");
        c.appendHTML(c.skin.body, '<div id="' + Y + '" style="' + a + '"></div>'),
        $ = B(Y),
        ba(),
        K($, "mousedown", ea)
    }
    function da() {
        $ && (L($, "mousedown", ea),
        C($),
        $ = null),
        _ = null
    }
    function ea(a) {
        I(a);
        var b = H(a);
        Z.startX = b[0],
        Z.startY = b[1],
        _ = B(c.player.id),
        K(document, "mousemove", fa),
        K(document, "mouseup", ga),
        c.isGecko && ($.style.cursor = "-moz-grabbing")
    }
    function fa(a) {
        var b = c.player
          , d = c.dimensions
          , e = H(a)
          , f = e[0] - Z.startX;
        Z.startX += f,
        Z.x = Math.max(Math.min(0, Z.x + f), d.innerWidth - b.width);
        var g = e[1] - Z.startY;
        Z.startY += g,
        Z.y = Math.max(Math.min(0, Z.y + g), d.innerHeight - b.height),
        x(_.style, {
            left: Z.x + "px",
            top: Z.y + "px"
        })
    }
    function ga() {
        L(document, "mousemove", fa),
        L(document, "mouseup", ga),
        c.isGecko && ($.style.cursor = "-moz-grab")
    }
    function ra(a, b, d, e, f) {
        var g = "opacity" == b
          , h = g ? c.setOpacity : function(a, c) {
            a.style[b] = "" + c + "px"
        }
        ;
        if (0 == e || !g && !c.options.animate || g && !c.options.animateFade)
            return h(a, d),
            void (f && f());
        var i = parseFloat(c.getStyle(a, b)) || 0
          , j = d - i;
        if (0 == j)
            return void (f && f());
        e *= 1e3;
        var n, k = w(), l = c.ease, m = k + e, o = setInterval(function() {
            n = w(),
            n >= m ? (clearInterval(o),
            o = null,
            h(a, d),
            f && f()) : h(a, i + l((n - k) / e) * j)
        }, 10)
    }
    function sa() {
        na.style.height = c.getWindowSize("Height") + "px",
        na.style.width = c.getWindowSize("Width") + "px"
    }
    function ta() {
        na.style.top = document.documentElement.scrollTop + "px",
        na.style.left = document.documentElement.scrollLeft + "px"
    }
    function ua(a) {
        a ? y(la, function(a, b) {
            b[0].style.visibility = b[1] || ""
        }) : (la = [],
        y(c.options.troubleElements, function(a, b) {
            y(document.getElementsByTagName(b), function(a, b) {
                la.push([b, b.style.visibility]),
                b.style.visibility = "hidden"
            })
        }))
    }
    function va(a, b) {
        var c = B("sb-nav-" + a);
        c && (c.style.display = b ? "" : "none")
    }
    function wa(a, b) {
        var d = B("sb-loading")
          , e = c.getCurrent().player
          , f = "img" == e || "html" == e;
        if (a) {
            c.setOpacity(d, 0),
            d.style.display = "block";
            var g = function() {
                c.clearOpacity(d),
                b && b()
            };
            f ? ra(d, "opacity", 1, c.options.fadeDuration, g) : g()
        } else {
            var g = function() {
                d.style.display = "none",
                c.clearOpacity(d),
                b && b()
            };
            f ? ra(d, "opacity", 0, c.options.fadeDuration, g) : g()
        }
    }
    function xa(a) {
        var b = c.getCurrent();
        B("sb-title-inner").innerHTML = b.title || "";
        var d, e, f, g, h;
        if (c.options.displayNav) {
            d = !0;
            var i = c.gallery.length;
            i > 1 && (c.options.continuous ? e = h = !0 : (e = i - 1 > c.current,
            h = c.current > 0)),
            c.options.slideshowDelay > 0 && c.hasNext() && (g = !c.isPaused(),
            f = !g)
        } else
            d = e = f = g = h = !1;
        va("close", d),
        va("next", e),
        va("play", f),
        va("pause", g),
        va("previous", h);
        var j = "";
        if (c.options.displayCounter && c.gallery.length > 1) {
            var i = c.gallery.length;
            if ("skip" == c.options.counterType) {
                var k = 0
                  , l = i
                  , m = parseInt(c.options.counterLimit) || 0;
                if (m < i && m > 2) {
                    var n = Math.floor(m / 2);
                    k = c.current - n,
                    k < 0 && (k += i),
                    l = c.current + (m - n),
                    l > i && (l -= i)
                }
                for (; k != l; )
                    k == i && (k = 0),
                    j += '<a onclick="Shadowbox.change(' + k + ');"',
                    k == c.current && (j += ' class="sb-counter-current"'),
                    j += ">" + ++k + "</a>"
            } else
                j = [c.current + 1, c.lang.of, i].join(" ")
        }
        B("sb-counter").innerHTML = j,
        a()
    }
    function ya(a) {
        var b = B("sb-title-inner")
          , c = B("sb-info-inner")
          , d = .35;
        b.style.visibility = c.style.visibility = "",
        "" != b.innerHTML && ra(b, "marginTop", 0, d),
        ra(c, "marginTop", 0, d, a)
    }
    function za(a, b) {
        var c = B("sb-title")
          , d = B("sb-info")
          , e = c.offsetHeight
          , f = d.offsetHeight
          , g = B("sb-title-inner")
          , h = B("sb-info-inner")
          , i = a ? .35 : 0;
        ra(g, "marginTop", e, i),
        ra(h, "marginTop", f * -1, i, function() {
            g.style.visibility = h.style.visibility = "hidden",
            b()
        })
    }
    function Aa(a, b, d, e) {
        var f = B("sb-wrapper-inner")
          , g = d ? c.options.resizeDuration : 0;
        ra(pa, "top", b, g),
        ra(f, "height", a, g, e)
    }
    function Ba(a, b, d, e) {
        var f = d ? c.options.resizeDuration : 0;
        ra(pa, "left", b, f),
        ra(pa, "width", a, f, e)
    }
    function Ca(a, b) {
        var d = B("sb-body-inner")
          , a = parseInt(a)
          , b = parseInt(b)
          , e = pa.offsetHeight - d.offsetHeight
          , f = pa.offsetWidth - d.offsetWidth
          , g = oa.offsetHeight
          , h = oa.offsetWidth
          , i = parseInt(c.options.viewportPadding) || 20
          , j = c.player && "drag" != c.options.handleOversize;
        return c.setDimensions(a, b, g, h, e, f, i, j)
    }
    var c = {
        version: "3.0.3"
    }
      , d = navigator.userAgent.toLowerCase();
    d.indexOf("windows") > -1 || d.indexOf("win32") > -1 ? c.isWindows = !0 : d.indexOf("macintosh") > -1 || d.indexOf("mac os x") > -1 ? c.isMac = !0 : d.indexOf("linux") > -1 && (c.isLinux = !0),
    c.isIE = d.indexOf("msie") > -1,
    c.isIE6 = d.indexOf("msie 6") > -1,
    c.isIE7 = d.indexOf("msie 7") > -1,
    c.isGecko = d.indexOf("gecko") > -1 && d.indexOf("safari") == -1,
    c.isWebKit = d.indexOf("applewebkit/") > -1;
    var n, o, e = /#(.+)$/, f = /^(light|shadow)box\[(.*?)\]/i, g = /\s*([a-z_]*?)\s*=\s*(.+)\s*/, h = /[0-9a-z]+$/i, i = /(.+\/)shadowbox\.js/i, j = !1, k = !1, l = {}, m = 0;
    c.current = -1,
    c.dimensions = null,
    c.ease = function(a) {
        return 1 + Math.pow(a - 1, 3)
    }
    ,
    c.errorInfo = {
        fla: {
            name: "Flash",
            url: "http://www.adobe.com/products/flashplayer/"
        },
        qt: {
            name: "QuickTime",
            url: "http://www.apple.com/quicktime/download/"
        },
        wmp: {
            name: "Windows Media Player",
            url: "http://www.microsoft.com/windows/windowsmedia/"
        },
        f4m: {
            name: "Flip4Mac",
            url: "http://www.flip4mac.com/wmv_download.htm"
        }
    },
    c.gallery = [],
    c.onReady = A,
    c.path = null,
    c.player = null,
    c.playerId = "sb-player",
    c.options = {
        animate: !0,
        animateFade: !0,
        autoplayMovies: !0,
        continuous: !1,
        enableKeys: !0,
        flashParams: {
            bgcolor: "#000000",
            allowfullscreen: !0
        },
        flashVars: {},
        flashVersion: "9.0.115",
        handleOversize: "resize",
        handleUnsupported: "link",
        onChange: A,
        onClose: A,
        onFinish: A,
        onOpen: A,
        showMovieControls: !0,
        skipSetup: !1,
        slideshowDelay: 0,
        viewportPadding: 20
    },
    c.getCurrent = function() {
        return c.current > -1 ? c.gallery[c.current] : null
    }
    ,
    c.hasNext = function() {
        return c.gallery.length > 1 && (c.current != c.gallery.length - 1 || c.options.continuous)
    }
    ,
    c.isOpen = function() {
        return j
    }
    ,
    c.isPaused = function() {
        return "pause" == o
    }
    ,
    c.applyOptions = function(a) {
        l = x({}, c.options),
        x(c.options, a)
    }
    ,
    c.revertOptions = function() {
        x(c.options, l)
    }
    ,
    c.init = function(a, b) {
        if (!k) {
            if (k = !0,
            c.skin.options && x(c.options, c.skin.options),
            a && x(c.options, a),
            !c.path)
                for (var d, e = document.getElementsByTagName("script"), f = 0, g = e.length; f < g; ++f)
                    if (d = i.exec(e[f].src)) {
                        c.path = d[1];
                        break
                    }
            b && (c.onReady = b),
            P()
        }
    }
    ,
    c.open = function(a) {
        if (!j) {
            var b = c.makeGallery(a);
            if (c.gallery = b[0],
            c.current = b[1],
            a = c.getCurrent(),
            null != a) {
                if (c.applyOptions(a.options || {}),
                p(),
                c.gallery.length) {
                    if (a = c.getCurrent(),
                    c.options.onOpen(a) === !1)
                        return;
                    j = !0,
                    c.skin.onOpen(a, s)
                }
                c.originalZIndex = jQuery("#qet-box-container").css("z-index"),
                jQuery("#qet-box-container").css("z-index", "1")
            }
        }
    }
    ,
    c.close = function() {
        j && (j = !1,
        c.player && (c.player.remove(),
        c.player = null),
        "number" == typeof o && (clearTimeout(o),
        o = null),
        m = 0,
        q(!1),
        c.options.onClose(c.getCurrent()),
        c.skin.onClose(),
        c.revertOptions(),
        "" != c.originalZIndex && jQuery("#qet-box-container").css("z-index", c.originalZIndex))
    }
    ,
    c.play = function() {
        c.hasNext() && (m || (m = 1e3 * c.options.slideshowDelay),
        m && (n = w(),
        o = setTimeout(function() {
            m = n = 0,
            c.next()
        }, m),
        c.skin.onPlay && c.skin.onPlay()))
    }
    ,
    c.pause = function() {
        "number" == typeof o && (m = Math.max(0, m - (w() - n)),
        m && (clearTimeout(o),
        o = "pause",
        c.skin.onPause && c.skin.onPause()))
    }
    ,
    c.change = function(a) {
        if (!(a in c.gallery)) {
            if (!c.options.continuous)
                return;
            if (a = a < 0 ? c.gallery.length + a : 0,
            !(a in c.gallery))
                return
        }
        c.current = a,
        "number" == typeof o && (clearTimeout(o),
        o = null,
        m = n = 0),
        c.options.onChange(c.getCurrent()),
        s(!0)
    }
    ,
    c.next = function() {
        c.change(c.current + 1)
    }
    ,
    c.previous = function() {
        c.change(c.current - 1)
    }
    ,
    c.setDimensions = function(a, b, d, e, f, g, h, i) {
        var j = a
          , k = b
          , l = 2 * h + f;
        a + l > d && (a = d - l);
        var m = 2 * h + g;
        b + m > e && (b = e - m);
        var n = (j - a) / j
          , o = (k - b) / k
          , p = n > 0 || o > 0;
        return i && p && (n > o ? b = Math.round(k / j * a) : o > n && (a = Math.round(j / k * b))),
        c.dimensions = {
            height: a + f,
            width: b + g,
            innerHeight: a,
            innerWidth: b,
            top: Math.floor((d - (a + l)) / 2 + h),
            left: Math.floor((e - (b + m)) / 2 + h),
            oversized: p
        },
        c.dimensions
    }
    ,
    c.makeGallery = function(a) {
        var b = []
          , d = -1;
        if ("string" == typeof a && (a = [a]),
        "number" == typeof a.length)
            y(a, function(a, c) {
                c.content ? b[a] = c : b[a] = {
                    content: c
                }
            }),
            d = 0;
        else {
            if (a.tagName) {
                var e = c.getCache(a);
                a = e ? e : c.makeObject(a)
            }
            if (a.gallery) {
                b = [];
                var f;
                for (var g in c.cache)
                    f = c.cache[g],
                    f.gallery && f.gallery == a.gallery && (d == -1 && f.content == a.content && (d = b.length),
                    b.push(f));
                d == -1 && (b.unshift(a),
                d = 0)
            } else
                b = [a],
                d = 0
        }
        return y(b, function(a, c) {
            b[a] = x({}, c)
        }),
        [b, d]
    }
    ,
    c.makeObject = function(a, b) {
        var d = {
            content: a.href,
            title: a.getAttribute("title") || "",
            link: a
        };
        b ? (b = x({}, b),
        y(["player", "title", "height", "width", "gallery"], function(a, c) {
            "undefined" != typeof b[c] && (d[c] = b[c],
            delete b[c])
        }),
        d.options = b) : d.options = {},
        d.player || (d.player = c.getPlayer(d.content));
        var e = a.getAttribute("rel");
        if (e) {
            var h = e.match(f);
            h && (d.gallery = escape(h[2])),
            y(e.split(";"), function(a, b) {
                h = b.match(g),
                h && (d[h[1]] = h[2])
            })
        }
        return d
    }
    ,
    c.getPlayer = function(a) {
        if (a.indexOf("#") > -1 && 0 == a.indexOf(document.location.href))
            return "inline";
        var b = a.indexOf("?");
        b > -1 && (a = a.substring(0, b));
        var d, e = a.match(h);
        if (e && (d = e[0].toLowerCase()),
        d) {
            if (c.img && c.img.ext.indexOf(d) > -1)
                return "img";
            if (c.swf && c.swf.ext.indexOf(d) > -1)
                return "swf";
            if (c.flv && c.flv.ext.indexOf(d) > -1)
                return "flv";
            if (c.qt && c.qt.ext.indexOf(d) > -1)
                return c.wmp && c.wmp.ext.indexOf(d) > -1 ? "qtwmp" : "qt";
            if (c.wmp && c.wmp.ext.indexOf(d) > -1)
                return "wmp"
        }
        return "iframe"
    }
    ,
    Array.prototype.indexOf || (Array.prototype.indexOf = function(a, b) {
        var c = this.length >>> 0;
        for (b = b || 0,
        b < 0 && (b += c); b < c; ++b)
            if (b in this && this[b] === a)
                return b;
        return -1
    }
    );
    var D = !0
      , E = !0;
    c.getStyle = function() {
        var a = /opacity=([^)]*)/
          , b = document.defaultView && document.defaultView.getComputedStyle;
        return function(c, d) {
            var e;
            if (!D && "opacity" == d && c.currentStyle)
                return e = a.test(c.currentStyle.filter || "") ? parseFloat(RegExp.$1) / 100 + "" : "",
                "" === e ? "1" : e;
            if (b) {
                var f = b(c, null);
                f && (e = f[d]),
                "opacity" == d && "" == e && (e = "1")
            } else
                e = c.currentStyle[d];
            return e
        }
    }(),
    c.appendHTML = function(a, b) {
        if (a.insertAdjacentHTML)
            a.insertAdjacentHTML("BeforeEnd", b);
        else if (a.lastChild) {
            var c = a.ownerDocument.createRange();
            c.setStartAfter(a.lastChild);
            var d = c.createContextualFragment(b);
            a.appendChild(d)
        } else
            a.innerHTML = b
    }
    ,
    c.getWindowSize = function(a) {
        return "CSS1Compat" === document.compatMode ? document.documentElement["client" + a] : document.body["client" + a]
    }
    ,
    c.setOpacity = function(a, b) {
        var c = a.style;
        D ? c.opacity = 1 == b ? "" : b : (c.zoom = 1,
        1 == b ? "string" == typeof c.filter && /alpha/i.test(c.filter) && (c.filter = c.filter.replace(/\s*[\w\.]*alpha\([^\)]*\);?/gi, "")) : c.filter = (c.filter || "").replace(/\s*[\w\.]*alpha\([^\)]*\)/gi, "") + " alpha(opacity=" + 100 * b + ")")
    }
    ,
    c.clearOpacity = function(a) {
        c.setOpacity(a, 1)
    }
    ,
    jQuery.fn.shadowbox = function(a) {
        return this.each(function() {
            var b = jQuery(this)
              , c = jQuery.extend({}, a || {}, jQuery.metadata ? b.metadata() : jQuery.meta ? b.data() : {})
              , d = this.className || "";
            c.width = parseInt((d.match(/w:(\d+)/) || [])[1]) || c.width,
            c.height = parseInt((d.match(/h:(\d+)/) || [])[1]) || c.height,
            Shadowbox.setup(b, c)
        })
    }
    ;
    var N, M = !1;
    if (document.addEventListener ? N = function() {
        document.removeEventListener("DOMContentLoaded", N, !1),
        c.load()
    }
    : document.attachEvent && (N = function() {
        "complete" === document.readyState && (document.detachEvent("onreadystatechange", N),
        c.load())
    }
    ),
    c.load = function() {
        if (!M) {
            if (!document.body)
                return setTimeout(c.load, 13);
            M = !0,
            F(),
            c.onReady(),
            c.options.skipSetup || c.setup(),
            c.skin.init()
        }
    }
    ,
    c.plugins = {},
    navigator.plugins && navigator.plugins.length) {
        var Q = [];
        y(navigator.plugins, function(a, b) {
            Q.push(b.name)
        }),
        Q = Q.join(",");
        var R = Q.indexOf("Flip4Mac") > -1;
        c.plugins = {
            fla: Q.indexOf("Shockwave Flash") > -1,
            qt: Q.indexOf("QuickTime") > -1,
            wmp: !R && Q.indexOf("Windows Media") > -1,
            f4m: R
        }
    } else {
        var S = function(a) {
            var b;
            try {
                b = new ActiveXObject(a)
            } catch (a) {}
            return !!b
        };
        c.plugins = {
            fla: S("ShockwaveFlash.ShockwaveFlash"),
            qt: S("QuickTime.QuickTime"),
            wmp: S("wmplayer.ocx"),
            f4m: !1
        }
    }
    var T = /^(light|shadow)box/i
      , U = "shadowboxCacheKey"
      , V = 1;
    c.cache = {},
    c.select = function(a) {
        var b = [];
        if (a) {
            var e = a.length;
            if (e)
                if ("string" == typeof a)
                    c.find && (b = c.find(a));
                else if (2 == e && "string" == typeof a[0] && a[1].nodeType)
                    c.find && (b = c.find(a[0], a[1]));
                else
                    for (var f = 0; f < e; ++f)
                        b[f] = a[f];
            else
                b.push(a)
        } else {
            var d;
            y(document.getElementsByTagName("a"), function(a, c) {
                d = c.getAttribute("rel"),
                d && T.test(d) && b.push(c)
            })
        }
        return b
    }
    ,
    c.setup = function(a, b) {
        y(c.select(a), function(a, d) {
            c.addCache(d, b)
        })
    }
    ,
    c.teardown = function(a) {
        y(c.select(a), function(a, b) {
            c.removeCache(b)
        })
    }
    ,
    c.addCache = function(a, d) {
        var e = a[U];
        if (e == b) {
            var f = !0;
            for (var g in c.cache)
                if (c.cache[g].content == a.href) {
                    f = !1;
                    break
                }
            f && (e = V++,
            a[U] = e,
            c.cache[e] = c.makeObject(a, d)),
            K(a, "click", W)
        }
    }
    ,
    c.removeCache = function(a) {
        L(a, "click", W),
        delete c.cache[a[U]],
        a[U] = null
    }
    ,
    c.getCache = function(a) {
        var b = a[U];
        return b in c.cache && c.cache[b]
    }
    ,
    c.clearCache = function() {
        for (var a in c.cache)
            c.removeCache(c.cache[a].link);
        c.cache = {}
    }
    ,
    c.find = function() {
        function m(a) {
            for (var c, b = "", d = 0; a[d]; d++)
                c = a[d],
                3 === c.nodeType || 4 === c.nodeType ? b += c.nodeValue : 8 !== c.nodeType && (b += m(c.childNodes));
            return b
        }
        function n(a, b, c, d, e, f) {
            for (var g = 0, h = d.length; g < h; g++) {
                var i = d[g];
                if (i) {
                    i = i[a];
                    for (var j = !1; i; ) {
                        if (i.sizcache === c) {
                            j = d[i.sizset];
                            break
                        }
                        if (1 !== i.nodeType || f || (i.sizcache = c,
                        i.sizset = g),
                        i.nodeName.toLowerCase() === b) {
                            j = i;
                            break
                        }
                        i = i[a]
                    }
                    d[g] = j
                }
            }
        }
        function o(a, b, c, d, e, f) {
            for (var h = 0, i = d.length; h < i; h++) {
                var j = d[h];
                if (j) {
                    j = j[a];
                    for (var k = !1; j; ) {
                        if (j.sizcache === c) {
                            k = d[j.sizset];
                            break
                        }
                        if (1 === j.nodeType)
                            if (f || (j.sizcache = c,
                            j.sizset = h),
                            "string" != typeof b) {
                                if (j === b) {
                                    k = !0;
                                    break
                                }
                            } else if (g.filter(b, [j]).length > 0) {
                                k = j;
                                break
                            }
                        j = j[a]
                    }
                    d[h] = k
                }
            }
        }
        var a = /((?:\((?:\([^()]+\)|[^()]+)+\)|\[(?:\[[^[\]]*\]|['"][^'"]*['"]|[^[\]'"]+)+\]|\\.|[^ >+~,(\[\\]+)+|[>+~])(\s*,\s*)?((?:.|\r|\n)*)/g
          , c = 0
          , d = Object.prototype.toString
          , e = !1
          , f = !0;
        [0, 0].sort(function() {
            return f = !1,
            0
        });
        var g = function(b, c, e, f) {
            e = e || [];
            var j = c = c || document;
            if (1 !== c.nodeType && 9 !== c.nodeType)
                return [];
            if (!b || "string" != typeof b)
                return e;
            for (var m, n, o, s, l = [], t = !0, u = q(c), v = b; null !== (a.exec(""),
            m = a.exec(v)); )
                if (v = m[3],
                l.push(m[1]),
                m[2]) {
                    s = m[3];
                    break
                }
            if (l.length > 1 && i.exec(b))
                if (2 === l.length && h.relative[l[0]])
                    n = r(l[0] + l[1], c);
                else
                    for (n = h.relative[l[0]] ? [c] : g(l.shift(), c); l.length; )
                        b = l.shift(),
                        h.relative[b] && (b += l.shift()),
                        n = r(b, n);
            else {
                if (!f && l.length > 1 && 9 === c.nodeType && !u && h.match.ID.test(l[0]) && !h.match.ID.test(l[l.length - 1])) {
                    var w = g.find(l.shift(), c, u);
                    c = w.expr ? g.filter(w.expr, w.set)[0] : w.set[0]
                }
                if (c) {
                    var w = f ? {
                        expr: l.pop(),
                        set: k(f)
                    } : g.find(l.pop(), 1 !== l.length || "~" !== l[0] && "+" !== l[0] || !c.parentNode ? c : c.parentNode, u);
                    for (n = w.expr ? g.filter(w.expr, w.set) : w.set,
                    l.length > 0 ? o = k(n) : t = !1; l.length; ) {
                        var x = l.pop()
                          , y = x;
                        h.relative[x] ? y = l.pop() : x = "",
                        null == y && (y = c),
                        h.relative[x](o, y, u)
                    }
                } else
                    o = l = []
            }
            if (o || (o = n),
            !o)
                throw "Syntax error, unrecognized expression: " + (x || b);
            if ("[object Array]" === d.call(o))
                if (t)
                    if (c && 1 === c.nodeType)
                        for (var z = 0; null != o[z]; z++)
                            o[z] && (o[z] === !0 || 1 === o[z].nodeType && p(c, o[z])) && e.push(n[z]);
                    else
                        for (var z = 0; null != o[z]; z++)
                            o[z] && 1 === o[z].nodeType && e.push(n[z]);
                else
                    e.push.apply(e, o);
            else
                k(o, e);
            return s && (g(s, j, e, f),
            g.uniqueSort(e)),
            e
        };
        g.uniqueSort = function(a) {
            if (l && (e = f,
            a.sort(l),
            e))
                for (var b = 1; b < a.length; b++)
                    a[b] === a[b - 1] && a.splice(b--, 1);
            return a
        }
        ,
        g.matches = function(a, b) {
            return g(a, null, null, b)
        }
        ,
        g.find = function(a, b, c) {
            var d, e;
            if (!a)
                return [];
            for (var f = 0, g = h.order.length; f < g; f++) {
                var e, i = h.order[f];
                if (e = h.leftMatch[i].exec(a)) {
                    var j = e[1];
                    if (e.splice(1, 1),
                    "\\" !== j.substr(j.length - 1) && (e[1] = (e[1] || "").replace(/\\/g, ""),
                    d = h.find[i](e, b, c),
                    null != d)) {
                        a = a.replace(h.match[i], "");
                        break
                    }
                }
            }
            return d || (d = b.getElementsByTagName("*")),
            {
                set: d,
                expr: a
            }
        }
        ,
        g.filter = function(a, c, d, e) {
            for (var j, k, f = a, g = [], i = c, l = c && c[0] && q(c[0]); a && c.length; ) {
                for (var m in h.filter)
                    if (null != (j = h.match[m].exec(a))) {
                        var o, p, n = h.filter[m];
                        if (k = !1,
                        i === g && (g = []),
                        h.preFilter[m])
                            if (j = h.preFilter[m](j, i, d, g, e, l)) {
                                if (j === !0)
                                    continue
                            } else
                                k = o = !0;
                        if (j)
                            for (var r = 0; null != (p = i[r]); r++)
                                if (p) {
                                    o = n(p, j, r, i);
                                    var s = e ^ !!o;
                                    d && null != o ? s ? k = !0 : i[r] = !1 : s && (g.push(p),
                                    k = !0)
                                }
                        if (o !== b) {
                            if (d || (i = g),
                            a = a.replace(h.match[m], ""),
                            !k)
                                return [];
                            break
                        }
                    }
                if (a === f) {
                    if (null == k)
                        throw "Syntax error, unrecognized expression: " + a;
                    break
                }
                f = a
            }
            return i
        }
        ;
        var h = g.selectors = {
            order: ["ID", "NAME", "TAG"],
            match: {
                ID: /#((?:[\w\u00c0-\uFFFF-]|\\.)+)/,
                CLASS: /\.((?:[\w\u00c0-\uFFFF-]|\\.)+)/,
                NAME: /\[name=['"]*((?:[\w\u00c0-\uFFFF-]|\\.)+)['"]*\]/,
                ATTR: /\[\s*((?:[\w\u00c0-\uFFFF-]|\\.)+)\s*(?:(\S?=)\s*(['"]*)(.*?)\3|)\s*\]/,
                TAG: /^((?:[\w\u00c0-\uFFFF\*-]|\\.)+)/,
                CHILD: /:(only|nth|last|first)-child(?:\((even|odd|[\dn+-]*)\))?/,
                POS: /:(nth|eq|gt|lt|first|last|even|odd)(?:\((\d*)\))?(?=[^-]|$)/,
                PSEUDO: /:((?:[\w\u00c0-\uFFFF-]|\\.)+)(?:\((['"]*)((?:\([^\)]+\)|[^\2\(\)]*)+)\2\))?/
            },
            leftMatch: {},
            attrMap: {
                class: "className",
                for: "htmlFor"
            },
            attrHandle: {
                href: function(a) {
                    return a.getAttribute("href")
                }
            },
            relative: {
                "+": function(a, b) {
                    var c = "string" == typeof b
                      , d = c && !/\W/.test(b)
                      , e = c && !d;
                    d && (b = b.toLowerCase());
                    for (var i, f = 0, h = a.length; f < h; f++)
                        if (i = a[f]) {
                            for (; (i = i.previousSibling) && 1 !== i.nodeType; )
                                ;
                            a[f] = e || i && i.nodeName.toLowerCase() === b ? i || !1 : i === b
                        }
                    e && g.filter(b, a, !0)
                },
                ">": function(a, b) {
                    var c = "string" == typeof b;
                    if (c && !/\W/.test(b)) {
                        b = b.toLowerCase();
                        for (var d = 0, e = a.length; d < e; d++) {
                            var f = a[d];
                            if (f) {
                                var h = f.parentNode;
                                a[d] = h.nodeName.toLowerCase() === b && h
                            }
                        }
                    } else {
                        for (var d = 0, e = a.length; d < e; d++) {
                            var f = a[d];
                            f && (a[d] = c ? f.parentNode : f.parentNode === b)
                        }
                        c && g.filter(b, a, !0)
                    }
                },
                "": function(a, b, d) {
                    var e = c++
                      , f = o;
                    if ("string" == typeof b && !/\W/.test(b)) {
                        var g = b = b.toLowerCase();
                        f = n
                    }
                    f("parentNode", b, e, a, g, d)
                },
                "~": function(a, b, d) {
                    var e = c++
                      , f = o;
                    if ("string" == typeof b && !/\W/.test(b)) {
                        var g = b = b.toLowerCase();
                        f = n
                    }
                    f("previousSibling", b, e, a, g, d)
                }
            },
            find: {
                ID: function(a, b, c) {
                    if ("undefined" != typeof b.getElementById && !c) {
                        var d = b.getElementById(a[1]);
                        return d ? [d] : []
                    }
                },
                NAME: function(a, b) {
                    if ("undefined" != typeof b.getElementsByName) {
                        for (var c = [], d = b.getElementsByName(a[1]), e = 0, f = d.length; e < f; e++)
                            d[e].getAttribute("name") === a[1] && c.push(d[e]);
                        return 0 === c.length ? null : c
                    }
                },
                TAG: function(a, b) {
                    return b.getElementsByTagName(a[1])
                }
            },
            preFilter: {
                CLASS: function(a, b, c, d, e, f) {
                    if (a = " " + a[1].replace(/\\/g, "") + " ",
                    f)
                        return a;
                    for (var h, g = 0; null != (h = b[g]); g++)
                        h && (e ^ (h.className && (" " + h.className + " ").replace(/[\t\n]/g, " ").indexOf(a) >= 0) ? c || d.push(h) : c && (b[g] = !1));
                    return !1
                },
                ID: function(a) {
                    return a[1].replace(/\\/g, "")
                },
                TAG: function(a, b) {
                    return a[1].toLowerCase()
                },
                CHILD: function(a) {
                    if ("nth" === a[1]) {
                        var b = /(-?)(\d*)n((?:\+|-)?\d*)/.exec("even" === a[2] && "2n" || "odd" === a[2] && "2n+1" || !/\D/.test(a[2]) && "0n+" + a[2] || a[2]);
                        a[2] = b[1] + (b[2] || 1) - 0,
                        a[3] = b[3] - 0
                    }
                    return a[0] = c++,
                    a
                },
                ATTR: function(a, b, c, d, e, f) {
                    var g = a[1].replace(/\\/g, "");
                    return !f && h.attrMap[g] && (a[1] = h.attrMap[g]),
                    "~=" === a[2] && (a[4] = " " + a[4] + " "),
                    a
                },
                PSEUDO: function(b, c, d, e, f) {
                    if ("not" === b[1]) {
                        if (!((a.exec(b[3]) || "").length > 1 || /^\w/.test(b[3]))) {
                            var i = g.filter(b[3], c, d, !0 ^ f);
                            return d || e.push.apply(e, i),
                            !1
                        }
                        b[3] = g(b[3], null, null, c)
                    } else if (h.match.POS.test(b[0]) || h.match.CHILD.test(b[0]))
                        return !0;
                    return b
                },
                POS: function(a) {
                    return a.unshift(!0),
                    a
                }
            },
            filters: {
                enabled: function(a) {
                    return a.disabled === !1 && "hidden" !== a.type
                },
                disabled: function(a) {
                    return a.disabled === !0
                },
                checked: function(a) {
                    return a.checked === !0
                },
                selected: function(a) {
                    return a.parentNode.selectedIndex,
                    a.selected === !0
                },
                parent: function(a) {
                    return !!a.firstChild
                },
                empty: function(a) {
                    return !a.firstChild
                },
                has: function(a, b, c) {
                    return !!g(c[3], a).length
                },
                header: function(a) {
                    return /h\d/i.test(a.nodeName)
                },
                text: function(a) {
                    return "text" === a.type
                },
                radio: function(a) {
                    return "radio" === a.type
                },
                checkbox: function(a) {
                    return "checkbox" === a.type
                },
                file: function(a) {
                    return "file" === a.type
                },
                password: function(a) {
                    return "password" === a.type
                },
                submit: function(a) {
                    return "submit" === a.type
                },
                image: function(a) {
                    return "image" === a.type
                },
                reset: function(a) {
                    return "reset" === a.type
                },
                button: function(a) {
                    return "button" === a.type || "button" === a.nodeName.toLowerCase()
                },
                input: function(a) {
                    return /input|select|textarea|button/i.test(a.nodeName)
                }
            },
            setFilters: {
                first: function(a, b) {
                    return 0 === b
                },
                last: function(a, b, c, d) {
                    return b === d.length - 1
                },
                even: function(a, b) {
                    return b % 2 === 0
                },
                odd: function(a, b) {
                    return b % 2 === 1
                },
                lt: function(a, b, c) {
                    return b < c[3] - 0
                },
                gt: function(a, b, c) {
                    return b > c[3] - 0
                },
                nth: function(a, b, c) {
                    return c[3] - 0 === b
                },
                eq: function(a, b, c) {
                    return c[3] - 0 === b
                }
            },
            filter: {
                PSEUDO: function(a, b, c, d) {
                    var e = b[1]
                      , f = h.filters[e];
                    if (f)
                        return f(a, c, b, d);
                    if ("contains" === e)
                        return (a.textContent || a.innerText || m([a]) || "").indexOf(b[3]) >= 0;
                    if ("not" === e) {
                        for (var g = b[3], c = 0, i = g.length; c < i; c++)
                            if (g[c] === a)
                                return !1;
                        return !0
                    }
                    throw "Syntax error, unrecognized expression: " + e
                },
                CHILD: function(a, b) {
                    var c = b[1]
                      , d = a;
                    switch (c) {
                    case "only":
                    case "first":
                        for (; d = d.previousSibling; )
                            if (1 === d.nodeType)
                                return !1;
                        if ("first" === c)
                            return !0;
                        d = a;
                    case "last":
                        for (; d = d.nextSibling; )
                            if (1 === d.nodeType)
                                return !1;
                        return !0;
                    case "nth":
                        var e = b[2]
                          , f = b[3];
                        if (1 === e && 0 === f)
                            return !0;
                        var g = b[0]
                          , h = a.parentNode;
                        if (h && (h.sizcache !== g || !a.nodeIndex)) {
                            var i = 0;
                            for (d = h.firstChild; d; d = d.nextSibling)
                                1 === d.nodeType && (d.nodeIndex = ++i);
                            h.sizcache = g
                        }
                        var j = a.nodeIndex - f;
                        return 0 === e ? 0 === j : j % e === 0 && j / e >= 0
                    }
                },
                ID: function(a, b) {
                    return 1 === a.nodeType && a.getAttribute("id") === b
                },
                TAG: function(a, b) {
                    return "*" === b && 1 === a.nodeType || a.nodeName.toLowerCase() === b
                },
                CLASS: function(a, b) {
                    return (" " + (a.className || a.getAttribute("class")) + " ").indexOf(b) > -1
                },
                ATTR: function(a, b) {
                    var c = b[1]
                      , d = h.attrHandle[c] ? h.attrHandle[c](a) : null != a[c] ? a[c] : a.getAttribute(c)
                      , e = d + ""
                      , f = b[2]
                      , g = b[4];
                    return null == d ? "!=" === f : "=" === f ? e === g : "*=" === f ? e.indexOf(g) >= 0 : "~=" === f ? (" " + e + " ").indexOf(g) >= 0 : g ? "!=" === f ? e !== g : "^=" === f ? 0 === e.indexOf(g) : "$=" === f ? e.substr(e.length - g.length) === g : "|=" === f && (e === g || e.substr(0, g.length + 1) === g + "-") : e && d !== !1
                },
                POS: function(a, b, c, d) {
                    var e = b[2]
                      , f = h.setFilters[e];
                    if (f)
                        return f(a, c, b, d)
                }
            }
        }
          , i = h.match.POS;
        for (var j in h.match)
            h.match[j] = new RegExp(h.match[j].source + /(?![^\[]*\])(?![^\(]*\))/.source),
            h.leftMatch[j] = new RegExp(/(^(?:.|\r|\n)*?)/.source + h.match[j].source);
        var k = function(a, b) {
            return a = Array.prototype.slice.call(a, 0),
            b ? (b.push.apply(b, a),
            b) : a
        };
        try {
            Array.prototype.slice.call(document.documentElement.childNodes, 0)
        } catch (a) {
            k = function(a, b) {
                var c = b || [];
                if ("[object Array]" === d.call(a))
                    Array.prototype.push.apply(c, a);
                else if ("number" == typeof a.length)
                    for (var e = 0, f = a.length; e < f; e++)
                        c.push(a[e]);
                else
                    for (var e = 0; a[e]; e++)
                        c.push(a[e]);
                return c
            }
        }
        var l;
        document.documentElement.compareDocumentPosition ? l = function(a, b) {
            if (!a.compareDocumentPosition || !b.compareDocumentPosition)
                return a == b && (e = !0),
                a.compareDocumentPosition ? -1 : 1;
            var c = 4 & a.compareDocumentPosition(b) ? -1 : a === b ? 0 : 1;
            return 0 === c && (e = !0),
            c
        }
        : "sourceIndex"in document.documentElement ? l = function(a, b) {
            if (!a.sourceIndex || !b.sourceIndex)
                return a == b && (e = !0),
                a.sourceIndex ? -1 : 1;
            var c = a.sourceIndex - b.sourceIndex;
            return 0 === c && (e = !0),
            c
        }
        : document.createRange && (l = function(a, b) {
            if (!a.ownerDocument || !b.ownerDocument)
                return a == b && (e = !0),
                a.ownerDocument ? -1 : 1;
            var c = a.ownerDocument.createRange()
              , d = b.ownerDocument.createRange();
            c.setStart(a, 0),
            c.setEnd(a, 0),
            d.setStart(b, 0),
            d.setEnd(b, 0);
            var f = c.compareBoundaryPoints(Range.START_TO_END, d);
            return 0 === f && (e = !0),
            f
        }
        ),
        function() {
            var a = document.createElement("div")
              , c = "script" + (new Date).getTime();
            a.innerHTML = "<a name='" + c + "'/>";
            var d = document.documentElement;
            d.insertBefore(a, d.firstChild),
            document.getElementById(c) && (h.find.ID = function(a, c, d) {
                if ("undefined" != typeof c.getElementById && !d) {
                    var e = c.getElementById(a[1]);
                    return e ? e.id === a[1] || "undefined" != typeof e.getAttributeNode && e.getAttributeNode("id").nodeValue === a[1] ? [e] : b : []
                }
            }
            ,
            h.filter.ID = function(a, b) {
                var c = "undefined" != typeof a.getAttributeNode && a.getAttributeNode("id");
                return 1 === a.nodeType && c && c.nodeValue === b
            }
            ),
            d.removeChild(a),
            d = a = null
        }(),
        function() {
            var a = document.createElement("div");
            a.appendChild(document.createComment("")),
            a.getElementsByTagName("*").length > 0 && (h.find.TAG = function(a, b) {
                var c = b.getElementsByTagName(a[1]);
                if ("*" === a[1]) {
                    for (var d = [], e = 0; c[e]; e++)
                        1 === c[e].nodeType && d.push(c[e]);
                    c = d
                }
                return c
            }
            ),
            a.innerHTML = "<a href='#'></a>",
            a.firstChild && "undefined" != typeof a.firstChild.getAttribute && "#" !== a.firstChild.getAttribute("href") && (h.attrHandle.href = function(a) {
                return a.getAttribute("href", 2)
            }
            ),
            a = null
        }(),
        document.querySelectorAll && !function() {
            var a = g
              , b = document.createElement("div");
            if (b.innerHTML = "<p class='TEST'></p>",
            !b.querySelectorAll || 0 !== b.querySelectorAll(".TEST").length) {
                g = function(b, c, d, e) {
                    if (c = c || document,
                    !e && 9 === c.nodeType && !q(c))
                        try {
                            return k(c.querySelectorAll(b), d)
                        } catch (a) {}
                    return a(b, c, d, e)
                }
                ;
                for (var c in a)
                    g[c] = a[c];
                b = null
            }
        }(),
        function() {
            var a = document.createElement("div");
            a.innerHTML = "<div class='test e'></div><div class='test'></div>",
            a.getElementsByClassName && 0 !== a.getElementsByClassName("e").length && (a.lastChild.className = "e",
            1 !== a.getElementsByClassName("e").length && (h.order.splice(1, 0, "CLASS"),
            h.find.CLASS = function(a, b, c) {
                if ("undefined" != typeof b.getElementsByClassName && !c)
                    return b.getElementsByClassName(a[1])
            }
            ,
            a = null))
        }();
        var p = document.compareDocumentPosition ? function(a, b) {
            return 16 & a.compareDocumentPosition(b)
        }
        : function(a, b) {
            return a !== b && (!a.contains || a.contains(b))
        }
          , q = function(a) {
            var b = (a ? a.ownerDocument || a : 0).documentElement;
            return !!b && "HTML" !== b.nodeName
        }
          , r = function(a, b) {
            for (var e, c = [], d = "", f = b.nodeType ? [b] : b; e = h.match.PSEUDO.exec(a); )
                d += e[0],
                a = a.replace(h.match.PSEUDO, "");
            a = h.relative[a] ? a + "*" : a;
            for (var i = 0, j = f.length; i < j; i++)
                g(a, f[i], c);
            return g.filter(d, c)
        };
        return g
    }(),
    c.flash = function() {
        var c = function() {
            function y() {
                "complete" == q.readyState && (q.parentNode.removeChild(q),
                z())
            }
            function z() {
                if (!u) {
                    if (w.ie && w.win) {
                        var a = M("span");
                        try {
                            var b = k.getElementsByTagName("body")[0].appendChild(a);
                            b.parentNode.removeChild(b)
                        } catch (a) {
                            return
                        }
                    }
                    u = !0,
                    r && (clearInterval(r),
                    r = null);
                    for (var c = m.length, d = 0; d < c; d++)
                        m[d]()
                }
            }
            function A(a) {
                u ? a() : m[m.length] = a
            }
            function B(a) {
                if (typeof j.addEventListener != d)
                    j.addEventListener("load", a, !1);
                else if (typeof k.addEventListener != d)
                    k.addEventListener("load", a, !1);
                else if (typeof j.attachEvent != d)
                    N(j, "onload", a);
                else if ("function" == typeof j.onload) {
                    var b = j.onload;
                    j.onload = function() {
                        b(),
                        a()
                    }
                } else
                    j.onload = a
            }
            function C() {
                for (var a = n.length, b = 0; b < a; b++) {
                    var c = n[b].id;
                    if (w.pv[0] > 0) {
                        var d = L(c);
                        d && (n[b].width = d.getAttribute("width") ? d.getAttribute("width") : "0",
                        n[b].height = d.getAttribute("height") ? d.getAttribute("height") : "0",
                        O(n[b].swfVersion) ? (w.webkit && w.webkit < 312 && D(d),
                        Q(c, !0)) : n[b].expressInstall && !v && O("6.0.65") && (w.win || w.mac) ? E(n[b]) : F(d))
                    } else
                        Q(c, !0)
                }
            }
            function D(a) {
                var b = a.getElementsByTagName(e)[0];
                if (b) {
                    var c = M("embed")
                      , d = b.attributes;
                    if (d)
                        for (var f = d.length, g = 0; g < f; g++)
                            "DATA" == d[g].nodeName ? c.setAttribute("src", d[g].nodeValue) : c.setAttribute(d[g].nodeName, d[g].nodeValue);
                    var h = b.childNodes;
                    if (h)
                        for (var i = h.length, j = 0; j < i; j++)
                            1 == h[j].nodeType && "PARAM" == h[j].nodeName && c.setAttribute(h[j].getAttribute("name"), h[j].getAttribute("value"));
                    a.parentNode.replaceChild(c, a)
                }
            }
            function E(a) {
                v = !0;
                var b = L(a.id);
                if (b) {
                    if (a.altContentId) {
                        var c = L(a.altContentId);
                        c && (s = c,
                        t = a.altContentId)
                    } else
                        s = G(b);
                    !/%$/.test(a.width) && parseInt(a.width, 10) < 310 && (a.width = "310"),
                    !/%$/.test(a.height) && parseInt(a.height, 10) < 137 && (a.height = "137"),
                    k.title = k.title.slice(0, 47) + " - Flash Player Installation";
                    var d = w.ie && w.win ? "ActiveX" : "PlugIn"
                      , e = k.title
                      , f = "MMredirectURL=" + j.location + "&MMplayerType=" + d + "&MMdoctitle=" + e
                      , g = a.id;
                    if (w.ie && w.win && 4 != b.readyState) {
                        var h = M("div");
                        g += "SWFObjectNew",
                        h.setAttribute("id", g),
                        b.parentNode.insertBefore(h, b),
                        b.style.display = "none";
                        var l = function() {
                            b.parentNode.removeChild(b)
                        };
                        N(j, "onload", l)
                    }
                    H({
                        data: a.expressInstall,
                        id: i,
                        width: a.width,
                        height: a.height
                    }, {
                        flashvars: f
                    }, g)
                }
            }
            function F(a) {
                if (w.ie && w.win && 4 != a.readyState) {
                    var b = M("div");
                    a.parentNode.insertBefore(b, a),
                    b.parentNode.replaceChild(G(a), b),
                    a.style.display = "none";
                    var c = function() {
                        a.parentNode.removeChild(a)
                    };
                    N(j, "onload", c)
                } else
                    a.parentNode.replaceChild(G(a), a)
            }
            function G(a) {
                var b = M("div");
                if (w.win && w.ie)
                    b.innerHTML = a.innerHTML;
                else {
                    var c = a.getElementsByTagName(e)[0];
                    if (c) {
                        var d = c.childNodes;
                        if (d)
                            for (var f = d.length, g = 0; g < f; g++)
                                1 == d[g].nodeType && "PARAM" == d[g].nodeName || 8 == d[g].nodeType || b.appendChild(d[g].cloneNode(!0))
                    }
                }
                return b
            }
            function H(a, b, c) {
                var f, g = L(c);
                if (g)
                    if (typeof a.id == d && (a.id = c),
                    w.ie && w.win) {
                        var i = "";
                        for (var j in a)
                            a[j] != Object.prototype[j] && ("data" == j.toLowerCase() ? b.movie = a[j] : "styleclass" == j.toLowerCase() ? i += ' class="' + a[j] + '"' : "classid" != j.toLowerCase() && (i += " " + j + '="' + a[j] + '"'));
                        var k = "";
                        for (var l in b)
                            b[l] != Object.prototype[l] && (k += '<param name="' + l + '" value="' + b[l] + '" />');
                        g.outerHTML = '<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"' + i + ">" + k + "</object>",
                        o[o.length] = a.id,
                        f = L(a.id)
                    } else if (w.webkit && w.webkit < 312) {
                        var m = M("embed");
                        m.setAttribute("type", h);
                        for (var n in a)
                            a[n] != Object.prototype[n] && ("data" == n.toLowerCase() ? m.setAttribute("src", a[n]) : "styleclass" == n.toLowerCase() ? m.setAttribute("class", a[n]) : "classid" != n.toLowerCase() && m.setAttribute(n, a[n]));
                        for (var p in b)
                            b[p] != Object.prototype[p] && "movie" != p.toLowerCase() && m.setAttribute(p, b[p]);
                        g.parentNode.replaceChild(m, g),
                        f = m
                    } else {
                        var q = M(e);
                        q.setAttribute("type", h);
                        for (var r in a)
                            a[r] != Object.prototype[r] && ("styleclass" == r.toLowerCase() ? q.setAttribute("class", a[r]) : "classid" != r.toLowerCase() && q.setAttribute(r, a[r]));
                        for (var s in b)
                            b[s] != Object.prototype[s] && "movie" != s.toLowerCase() && I(q, s, b[s]);
                        g.parentNode.replaceChild(q, g),
                        f = q
                    }
                return f
            }
            function I(a, b, c) {
                var d = M("param");
                d.setAttribute("name", b),
                d.setAttribute("value", c),
                a.appendChild(d)
            }
            function J(a) {
                var b = L(a);
                !b || "OBJECT" != b.nodeName && "EMBED" != b.nodeName || (w.ie && w.win ? 4 == b.readyState ? K(a) : j.attachEvent("onload", function() {
                    K(a)
                }) : b.parentNode.removeChild(b))
            }
            function K(a) {
                var b = L(a);
                if (b) {
                    for (var c in b)
                        "function" == typeof b[c] && (b[c] = null);
                    b.parentNode.removeChild(b)
                }
            }
            function L(a) {
                var b = null;
                try {
                    b = k.getElementById(a)
                } catch (a) {}
                return b
            }
            function M(a) {
                return k.createElement(a)
            }
            function N(a, b, c) {
                a.attachEvent(b, c),
                p[p.length] = [a, b, c]
            }
            function O(a) {
                var b = w.pv
                  , c = a.split(".");
                return c[0] = parseInt(c[0], 10),
                c[1] = parseInt(c[1], 10) || 0,
                c[2] = parseInt(c[2], 10) || 0,
                b[0] > c[0] || b[0] == c[0] && b[1] > c[1] || b[0] == c[0] && b[1] == c[1] && b[2] >= c[2]
            }
            function P(a, b) {
                if (!w.ie || !w.mac) {
                    var c = k.getElementsByTagName("head")[0]
                      , f = M("style");
                    if (f.setAttribute("type", "text/css"),
                    f.setAttribute("media", "screen"),
                    w.ie && w.win || typeof k.createTextNode == d || f.appendChild(k.createTextNode(a + " {" + b + "}")),
                    c.appendChild(f),
                    w.ie && w.win && typeof k.styleSheets != d && k.styleSheets.length > 0) {
                        var g = k.styleSheets[k.styleSheets.length - 1];
                        typeof g.addRule == e && g.addRule(a, b)
                    }
                }
            }
            function Q(a, b) {
                var c = b ? "visible" : "hidden";
                u && L(a) ? L(a).style.visibility = c : P("#" + a, "visibility:" + c)
            }
            function R(a) {
                var b = /[\\\"<>\.;]/
                  , c = null != b.exec(a);
                return c ? encodeURIComponent(a) : a
            }
            var q, d = "undefined", e = "object", f = "Shockwave Flash", g = "ShockwaveFlash.ShockwaveFlash", h = "application/x-shockwave-flash", i = "SWFObjectExprInst", j = a, k = document, l = navigator, m = [], n = [], o = [], p = [], r = null, s = null, t = null, u = !1, v = !1, w = function() {
                var a = typeof k.getElementById != d && typeof k.getElementsByTagName != d && typeof k.createElement != d
                  , b = [0, 0, 0]
                  , c = null;
                if (typeof l.plugins != d && typeof l.plugins[f] == e)
                    c = l.plugins[f].description,
                    !c || typeof l.mimeTypes != d && l.mimeTypes[h] && !l.mimeTypes[h].enabledPlugin || (c = c.replace(/^.*\s+(\S+\s+\S+$)/, "$1"),
                    b[0] = parseInt(c.replace(/^(.*)\..*$/, "$1"), 10),
                    b[1] = parseInt(c.replace(/^.*\.(.*)\s.*$/, "$1"), 10),
                    b[2] = /r/.test(c) ? parseInt(c.replace(/^.*r(.*)$/, "$1"), 10) : 0);
                else if (typeof j.ActiveXObject != d) {
                    var i = null
                      , m = !1;
                    try {
                        i = new ActiveXObject(g + ".7")
                    } catch (a) {
                        try {
                            i = new ActiveXObject(g + ".6"),
                            b = [6, 0, 21],
                            i.AllowScriptAccess = "always"
                        } catch (a) {
                            6 == b[0] && (m = !0)
                        }
                        if (!m)
                            try {
                                i = new ActiveXObject(g)
                            } catch (a) {}
                    }
                    if (!m && i)
                        try {
                            c = i.GetVariable("$version"),
                            c && (c = c.split(" ")[1].split(","),
                            b = [parseInt(c[0], 10), parseInt(c[1], 10), parseInt(c[2], 10)])
                        } catch (a) {}
                }
                var n = l.userAgent.toLowerCase()
                  , o = l.platform.toLowerCase()
                  , p = !!/webkit/.test(n) && parseFloat(n.replace(/^.*webkit\/(\d+(\.\d+)?).*$/, "$1"))
                  , q = !1
                  , r = o ? /win/.test(o) : /win/.test(n)
                  , s = o ? /mac/.test(o) : /mac/.test(n);
                return {
                    w3cdom: a,
                    pv: b,
                    webkit: p,
                    ie: q,
                    win: r,
                    mac: s
                }
            }();
            (function() {
                if (w.w3cdom) {
                    if (A(C),
                    w.ie && w.win)
                        try {
                            k.write("<script id=__ie_ondomload defer=true src=//:></script>"),
                            q = L("__ie_ondomload"),
                            q && N(q, "onreadystatechange", y)
                        } catch (a) {}
                    w.webkit && typeof k.readyState != d && (r = setInterval(function() {
                        /loaded|complete/.test(k.readyState) && z()
                    }, 10)),
                    typeof k.addEventListener != d && k.addEventListener("DOMContentLoaded", z, null),
                    B(z)
                }
            }
            )(),
            function() {
                w.ie && w.win && a.attachEvent("onunload", function() {
                    for (var a = p.length, b = 0; b < a; b++)
                        p[b][0].detachEvent(p[b][1], p[b][2]);
                    for (var d = o.length, e = 0; e < d; e++)
                        J(o[e]);
                    for (var f in w)
                        w[f] = null;
                    w = null;
                    for (var g in c)
                        c[g] = null;
                    c = null
                })
            }();
            return {
                registerObject: function(a, b, c) {
                    if (w.w3cdom && a && b) {
                        var d = {};
                        d.id = a,
                        d.swfVersion = b,
                        d.expressInstall = !!c && c,
                        n[n.length] = d,
                        Q(a, !1)
                    }
                },
                getObjectById: function(a) {
                    var b = null;
                    if (w.w3cdom) {
                        var c = L(a);
                        if (c) {
                            var f = c.getElementsByTagName(e)[0];
                            !f || f && typeof c.SetVariable != d ? b = c : typeof f.SetVariable != d && (b = f)
                        }
                    }
                    return b
                },
                embedSWF: function(a, b, c, f, g, h, i, j, k) {
                    if (w.w3cdom && a && b && c && f && g)
                        if (c += "",
                        f += "",
                        O(g)) {
                            Q(b, !1);
                            var l = {};
                            if (k && typeof k === e)
                                for (var m in k)
                                    k[m] != Object.prototype[m] && (l[m] = k[m]);
                            l.data = a,
                            l.width = c,
                            l.height = f;
                            var n = {};
                            if (j && typeof j === e)
                                for (var o in j)
                                    j[o] != Object.prototype[o] && (n[o] = j[o]);
                            if (i && typeof i === e)
                                for (var p in i)
                                    i[p] != Object.prototype[p] && (typeof n.flashvars != d ? n.flashvars += "&" + p + "=" + i[p] : n.flashvars = p + "=" + i[p]);
                            A(function() {
                                H(l, n, b),
                                l.id == b && Q(b, !0)
                            })
                        } else
                            h && !v && O("6.0.65") && (w.win || w.mac) && (v = !0,
                            Q(b, !1),
                            A(function() {
                                var a = {};
                                a.id = a.altContentId = b,
                                a.width = c,
                                a.height = f,
                                a.expressInstall = h,
                                E(a)
                            }))
                },
                getFlashPlayerVersion: function() {
                    return {
                        major: w.pv[0],
                        minor: w.pv[1],
                        release: w.pv[2]
                    }
                },
                hasFlashPlayerVersion: O,
                createSWF: function(a, c, d) {
                    return w.w3cdom ? H(a, c, d) : b
                },
                removeSWF: function(a) {
                    w.w3cdom && J(a)
                },
                createCSS: function(a, b) {
                    w.w3cdom && P(a, b)
                },
                addDomLoadEvent: A,
                addLoadEvent: B,
                getQueryParamValue: function(a) {
                    var b = k.location.search || k.location.hash;
                    if (null == a)
                        return R(b);
                    if (b)
                        for (var c = b.substring(1).split("&"), d = 0; d < c.length; d++)
                            if (c[d].substring(0, c[d].indexOf("=")) == a)
                                return R(c[d].substring(c[d].indexOf("=") + 1));
                    return ""
                },
                expressInstallCallback: function() {
                    if (v && s) {
                        var a = L(i);
                        a && (a.parentNode.replaceChild(s, a),
                        t && (Q(t, !0),
                        w.ie && w.win && (s.style.display = "block")),
                        s = null,
                        t = null,
                        v = !1)
                    }
                }
            }
        }();
        return c
    }(),
    c.lang = {
        code: "en",
        of: "of",
        loading: "",
        cancel: "Cancel",
        next: "Next",
        previous: "Previous",
        play: "Play",
        pause: "Pause",
        close: "Close",
        errors: {
            single: 'You must install the <a href="{0}">{1}</a> browser plugin to view this content.',
            shared: 'You must install both the <a href="{0}">{1}</a> and <a href="{2}">{3}</a> browser plugins to view this content.',
            either: 'You must install either the <a href="{0}">{1}</a> or the <a href="{2}">{3}</a> browser plugin to view this content.'
        }
    };
    var X, Z, $, _, Y = "sb-drag-proxy";
    c.img = function(a, b) {
        this.obj = a,
        this.id = b,
        this.ready = !1;
        var c = this;
        X = new Image,
        X.onload = function() {
            c.height = a.height ? parseInt(a.height, 10) : X.height,
            c.width = a.width ? parseInt(a.width, 10) : X.width,
            c.ready = !0,
            X.onload = null,
            X = null
        }
        ,
        X.src = a.content
    }
    ,
    c.img.ext = ["bmp", "gif", "jpg", "jpeg", "png"],
    c.img.prototype = {
        append: function(a, b) {
            var d = document.createElement("img");
            d.id = this.id,
            d.src = this.obj.content,
            d.style.position = "absolute";
            var e, f;
            b.oversized && "resize" == c.options.handleOversize ? (e = b.innerHeight,
            f = b.innerWidth) : (e = this.height,
            f = this.width),
            d.setAttribute("height", e),
            d.setAttribute("width", f),
            a.appendChild(d)
        },
        remove: function() {
            var a = B(this.id);
            a && C(a),
            da(),
            X && (X.onload = null,
            X = null)
        },
        onLoad: function() {
            var a = c.dimensions;
            a.oversized && "drag" == c.options.handleOversize && ca()
        },
        onWindowResize: function() {
            var a = c.dimensions;
            switch (c.options.handleOversize) {
            case "resize":
                var b = B(this.id);
                b.height = a.innerHeight,
                b.width = a.innerWidth;
                break;
            case "drag":
                if (_) {
                    var d = parseInt(c.getStyle(_, "top"))
                      , e = parseInt(c.getStyle(_, "left"));
                    d + this.height < a.innerHeight && (_.style.top = a.innerHeight - this.height + "px"),
                    e + this.width < a.innerWidth && (_.style.left = a.innerWidth - this.width + "px"),
                    ba()
                }
            }
        }
    },
    c.iframe = function(a, b) {
        this.obj = a,
        this.id = b;
        var c = B("sb-overlay");
        this.height = a.height ? parseInt(a.height, 10) : c.offsetHeight,
        this.width = a.width ? parseInt(a.width, 10) : c.offsetWidth
    }
    ,
    c.iframe.prototype = {
        append: function(a, b) {
            var d = '<iframe id="' + this.id + '" name="' + this.id + '" height="100%" width="100%" frameborder="0" marginwidth="0" marginheight="0" style="visibility:hidden" onload="this.style.visibility=\'visible\'" scrolling="auto"';
            c.isIE && (d += ' allowtransparency="true"',
            c.isIE6 && (d += " src=\"javascript:false;document.write('');\"")),
            d += "></iframe>",
            a.innerHTML = d
        },
        remove: function() {
            var b = B(this.id);
            b && (C(b),
            c.isGecko && delete a.frames[this.id])
        },
        onLoad: function() {
            var b = c.isIE ? B(this.id).contentWindow : a.frames[this.id];
            b.location.href = this.obj.content
        }
    },
    c.html = function(a, b) {
        this.obj = a,
        this.id = b,
        this.height = a.height ? parseInt(a.height, 10) : 300,
        this.width = a.width ? parseInt(a.width, 10) : 500
    }
    ,
    c.html.prototype = {
        append: function(a, b) {
            var c = document.createElement("div");
            c.id = this.id,
            c.className = "html",
            c.innerHTML = this.obj.content,
            a.appendChild(c)
        },
        remove: function() {
            var a = B(this.id);
            a && C(a)
        }
    },
    c.swf = function(a, b) {
        this.obj = a,
        this.id = b,
        this.height = a.height ? parseInt(a.height, 10) : 300,
        this.width = a.width ? parseInt(a.width, 10) : 300
    }
    ,
    c.swf.ext = ["swf"],
    c.swf.prototype = {
        append: function(a, b) {
            var d = document.createElement("div");
            d.id = this.id,
            a.appendChild(d);
            var e = b.innerHeight
              , f = b.innerWidth
              , g = this.obj.content
              , h = c.options.flashVersion
              , i = c.path + "expressInstall.swf"
              , j = c.options.flashVars
              , k = c.options.flashParams;
            c.flash.embedSWF(g, this.id, f, e, h, i, j, k)
        },
        remove: function() {
            c.flash.expressInstallCallback(),
            c.flash.removeSWF(this.id)
        },
        onWindowResize: function() {
            var a = c.dimensions
              , b = B(this.id);
            b.height = a.innerHeight,
            b.width = a.innerWidth
        }
    };
    var ha = 20;
    c.flv = function(a, b) {
        this.obj = a,
        this.id = b,
        this.height = a.height ? parseInt(a.height, 10) : 300,
        c.options.showMovieControls && (this.height += ha),
        this.width = a.width ? parseInt(a.width, 10) : 300
    }
    ,
    c.flv.ext = ["flv", "m4v"],
    c.flv.prototype = {
        append: function(a, b) {
            var d = document.createElement("div");
            d.id = this.id,
            a.appendChild(d);
            var e = b.innerHeight
              , f = b.innerWidth
              , g = c.path + "player.swf"
              , h = c.options.flashVersion
              , i = c.path + "expressInstall.swf"
              , j = x({
                file: this.obj.content,
                height: e,
                width: f,
                autostart: c.options.autoplayMovies ? "true" : "false",
                controlbar: c.options.showMovieControls ? "bottom" : "none",
                backcolor: "0x000000",
                frontcolor: "0xCCCCCC",
                lightcolor: "0x557722"
            }, c.options.flashVars)
              , k = c.options.flashParams;
            c.flash.embedSWF(g, this.id, f, e, h, i, j, k)
        },
        remove: function() {
            c.flash.expressInstallCallback(),
            c.flash.removeSWF(this.id)
        },
        onWindowResize: function() {
            var a = c.dimensions
              , b = B(this.id);
            b.height = a.innerHeight,
            b.width = a.innerWidth
        }
    };
    var ia = 16;
    c.qt = function(a, b) {
        this.obj = a,
        this.id = b,
        this.height = a.height ? parseInt(a.height, 10) : 300,
        c.options.showMovieControls && (this.height += ia),
        this.width = a.width ? parseInt(a.width, 10) : 300
    }
    ,
    c.qt.ext = ["dv", "mov", "moov", "movie", "mp4", "avi", "mpg", "mpeg"],
    c.qt.prototype = {
        append: function(a, b) {
            var d = c.options
              , e = String(d.autoplayMovies)
              , f = String(d.showMovieControls)
              , g = "<object"
              , h = {
                id: this.id,
                name: this.id,
                height: this.height,
                width: this.width,
                kioskmode: "true"
            };
            c.isIE ? (h.classid = "clsid:02BF25D5-8C17-4B23-BC80-D3488ABDDC6B",
            h.codebase = "http://www.apple.com/qtactivex/qtplugin.cab#version=6,0,2,0") : (h.type = "video/quicktime",
            h.data = this.obj.content);
            for (var i in h)
                g += " " + i + '="' + h[i] + '"';
            g += ">";
            var j = {
                src: this.obj.content,
                scale: "aspect",
                controller: f,
                autoplay: e
            };
            for (var k in j)
                g += '<param name="' + k + '" value="' + j[k] + '">';
            g += "</object>",
            a.innerHTML = g
        },
        remove: function() {
            try {
                document[this.id].Stop()
            } catch (a) {}
            var a = B(this.id);
            a && C(a)
        }
    };
    var ja = c.isIE ? 70 : 45;
    c.wmp = function(a, b) {
        this.obj = a,
        this.id = b,
        this.height = a.height ? parseInt(a.height, 10) : 300,
        c.options.showMovieControls && (this.height += ja),
        this.width = a.width ? parseInt(a.width, 10) : 300
    }
    ,
    c.wmp.ext = ["asf", "avi", "mpg", "mpeg", "wm", "wmv"],
    c.wmp.prototype = {
        append: function(a, b) {
            var d = c.options
              , f = (d.autoplayMovies ? 1 : 0,
            '<object id="' + this.id + '" name="' + this.id + '" height="' + this.height + '" width="' + this.width + '"')
              , g = {
                autostart: d.autoplayMovies ? 1 : 0
            };
            c.isIE ? (f += ' classid="clsid:6BF52A52-394A-11d3-B153-00C04F79FAA6"',
            g.url = this.obj.content,
            g.uimode = d.showMovieControls ? "full" : "none") : (f += ' type="video/x-ms-wmv"',
            f += ' data="' + this.obj.content + '"',
            g.showcontrols = d.showMovieControls ? 1 : 0),
            f += ">";
            for (var h in g)
                f += '<param name="' + h + '" value="' + g[h] + '">';
            f += "</object>",
            a.innerHTML = f
        },
        remove: function() {
            if (c.isIE)
                try {
                    a[this.id].controls.stop(),
                    a[this.id].URL = "movie" + w() + ".wmv",
                    a[this.id] = function() {}
                } catch (a) {}
            var b = B(this.id);
            b && setTimeout(function() {
                C(b)
            }, 10)
        }
    };
    var na, oa, pa, ka = !1, la = [], ma = ["sb-nav-close", "sb-nav-next", "sb-nav-play", "sb-nav-pause", "sb-nav-previous"], qa = !0, Da = {};
    Da.markup = '<div id="sb-container"><div id="sb-overlay"></div><div id="sb-wrapper"><div id="sb-title"><div id="sb-title-inner"></div></div><div id="sb-wrapper-inner"><div id="sb-body"><div id="sb-body-inner"></div><div id="sb-loading"><div id="sb-loading-inner"><span>{loading}</span></div></div></div></div><div id="sb-info"><div id="sb-info-inner"><div id="sb-counter"></div><div id="sb-nav"><a id="sb-nav-close" title="{close}" onclick="Shadowbox.close()"></a><a id="sb-nav-next" title="{next}" onclick="Shadowbox.next()"></a><a id="sb-nav-play" title="{play}" onclick="Shadowbox.play()"></a><a id="sb-nav-pause" title="{pause}" onclick="Shadowbox.pause()"></a><a id="sb-nav-previous" title="{previous}" onclick="Shadowbox.previous()"></a></div></div></div></div></div>',
    Da.options = {
        animSequence: "sync",
        counterLimit: 10,
        counterType: "default",
        displayCounter: !0,
        displayNav: !0,
        fadeDuration: .35,
        initialHeight: 160,
        initialWidth: 320,
        modal: !1,
        overlayColor: "#000",
        overlayOpacity: .5,
        resizeDuration: .35,
        showOverlay: !0,
        troubleElements: ["select", "object", "embed", "canvas"]
    },
    Da.init = function() {
        if (c.appendHTML(document.body, z(Da.markup, c.lang)),
        Da.body = B("sb-body-inner"),
        na = B("sb-container"),
        oa = B("sb-overlay"),
        pa = B("sb-wrapper"),
        E || (na.style.position = "absolute"),
        !D) {
            var b, d, e = /url\("(.*\.png)"\)/;
            y(ma, function(a, f) {
                b = B(f),
                b && (d = c.getStyle(b, "backgroundImage").match(e),
                d && (b.style.backgroundImage = "none",
                b.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled=true,src=" + d[1] + ",sizingMethod=scale);"))
            })
        }
        var f;
        K(a, "resize", function() {
            f && (clearTimeout(f),
            f = null),
            j && (f = setTimeout(Da.onWindowResize, 10))
        })
    }
    ,
    Da.onOpen = function(b, d) {
        qa = !1,
        na.style.display = "block",
        sa();
        var e = Ca(c.options.initialHeight, c.options.initialWidth);
        Aa(e.innerHeight, e.top),
        Ba(e.width, e.left),
        c.options.showOverlay && (oa.style.backgroundColor = c.options.overlayColor,
        c.setOpacity(oa, 0),
        c.options.modal || K(oa, "click", c.close),
        ka = !0),
        E || (ta(),
        K(a, "scroll", ta)),
        ua(),
        na.style.visibility = "visible",
        ka ? ra(oa, "opacity", c.options.overlayOpacity, c.options.fadeDuration, d) : d()
    }
    ,
    Da.onLoad = function(a, b) {
        for (wa(!0); Da.body.firstChild; )
            C(Da.body.firstChild);
        za(a, function() {
            j && (a || (pa.style.visibility = "visible"),
            xa(b))
        })
    }
    ,
    Da.onReady = function(a) {
        if (j) {
            var b = c.player
              , d = Ca(b.height, b.width)
              , e = function() {
                ya(a)
            };
            switch (c.options.animSequence) {
            case "hw":
                Aa(d.innerHeight, d.top, !0, function() {
                    Ba(d.width, d.left, !0, e)
                });
                break;
            case "wh":
                Ba(d.width, d.left, !0, function() {
                    Aa(d.innerHeight, d.top, !0, e)
                });
                break;
            default:
                Ba(d.width, d.left, !0),
                Aa(d.innerHeight, d.top, !0, e)
            }
        }
    }
    ,
    Da.onShow = function(a) {
        wa(!1, a),
        qa = !0
    }
    ,
    Da.onClose = function() {
        E || L(a, "scroll", ta),
        L(oa, "click", c.close),
        pa.style.visibility = "hidden";
        var b = function() {
            na.style.visibility = "hidden",
            na.style.display = "none",
            ua(!0)
        };
        ka ? ra(oa, "opacity", 0, c.options.fadeDuration, b) : b()
    }
    ,
    Da.onPlay = function() {
        va("play", !1),
        va("pause", !0)
    }
    ,
    Da.onPause = function() {
        va("pause", !1),
        va("play", !0)
    }
    ,
    Da.onWindowResize = function() {
        if (qa) {
            sa();
            var a = c.player
              , b = Ca(a.height, a.width);
            Ba(b.width, b.left),
            Aa(b.innerHeight, b.top),
            a.onWindowResize && a.onWindowResize()
        }
    }
    ,
    c.skin = Da,
    a.Shadowbox = c
}(window);
