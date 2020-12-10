//package com.excalibur.funwithgles.sdmaidpro.ui;
//
//import android.content.Context;
//import android.content.res.Resources;
//import android.content.res.TypedArray;
//import android.util.AttributeSet;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.animation.Animation;
//import android.view.animation.AnimationUtils;
//import android.widget.FrameLayout;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//import androidx.fragment.app.Fragment;
//
//import com.airbnb.lottie.LottieAnimationView;
//import com.excalibur.funwithgles.App;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//
///* compiled from: ToolIntroView.kt */
//public final class ToolIntroView extends FrameLayout {
//    public static final String h = App.self().a("GlideGif");
//
//    /* renamed from: e  reason: collision with root package name */
//    public b f2288e;
//    @BindView
//    public TextView emptyCaption;
//    @BindView
//    public ViewGroup emptyContainer;
//    public final boolean f;
//    public int g;
//    @BindView
//    public ViewGroup introContainer;
//    @BindView
//    public TextView introDescription;
//    @BindView
//    public ImageView introIcon;
//    @BindView
//    public TextView introTitle;
//    @BindView
//    public LottieAnimationView workingAnimation;
//    @BindView
//    public ViewGroup workingContainer;
//
//    /* compiled from: ToolIntroView.kt */
//    public static final class a implements View.OnClickListener {
//
//        /* renamed from: e  reason: collision with root package name */
//        public final /* synthetic */ ToolIntroView f2289e;
//
//        public a(ToolIntroView toolIntroView) {
//            this.f2289e = toolIntroView;
//        }
//
//        public final void onClick(View view) {
//            ToolIntroView toolIntroView = this.f2289e;
//            if (toolIntroView.g == 5) {
//                Animation loadAnimation = AnimationUtils.loadAnimation(toolIntroView.getContext(), R.anim.easter_egg);
//                ViewGroup viewGroup = toolIntroView.workingContainer;
//                if (viewGroup != null) {
//                    viewGroup.startAnimation(loadAnimation);
//                    SDMContext sDMContext = App.s;
//                    i.a((Object) sDMContext, "App.getSDMContext()");
//                    sDMContext.getMatomo().a("Wiggle");
//                } else {
//                    i.b("workingContainer");
//                    throw null;
//                }
//            }
//            if (toolIntroView.g == 25) {
//                Toast.makeText(toolIntroView.getContext(), "Don't touch the maid!", 0).show();
//                SDMContext sDMContext2 = App.s;
//                i.a((Object) sDMContext2, "App.getSDMContext()");
//                sDMContext2.getMatomo().a("No touching");
//            }
//            if (toolIntroView.g == 50) {
//                Context context = toolIntroView.getContext();
//                i.a((Object) context, "context");
//                Resources resources = context.getResources();
//                i.a((Object) resources, "context.resources");
//                if (resources.getConfiguration().orientation == 2) {
//                    t.d dVar = new t.d(new t(toolIntroView.getContext()).a, "https://twitter.com/d4rken/status/713775128912461826");
//                    dVar.g = true;
//                    dVar.c();
//                } else {
//                    t.d dVar2 = new t.d(new t(toolIntroView.getContext()).a, "https://darken.eu/coffee.gif");
//                    dVar2.g = true;
//                    dVar2.c();
//                }
//                SDMContext sDMContext3 = App.s;
//                i.a((Object) sDMContext3, "App.getSDMContext()");
//                sDMContext3.getMatomo().a("Coffee Gif");
//            }
//            toolIntroView.g++;
//        }
//    }
//
//    /* compiled from: ToolIntroView.kt */
//    public enum b {
//        INTRO,
//        WORKING,
//        NORESULTS,
//        GONE
//    }
//
//    public ToolIntroView(Context context) {
//        this(context, (AttributeSet) null, 0, 6, (f) null);
//    }
//
//    public ToolIntroView(Context context, AttributeSet attributeSet) {
//        this(context, attributeSet, 0, 4, (f) null);
//    }
//
//    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
//    public ToolIntroView(Context context, AttributeSet attributeSet, int i) {
//        super(context, attributeSet, i);
//        if (context != null) {
//            this.f2288e = b.GONE;
//            GeneralPreferencesFragment generalPreferencesFragment = GeneralPreferencesFragment.f2125n0;
//            SDMContext sDMContext = App.s;
//            i.a((Object) sDMContext, "App.getSDMContext()");
//            this.f = GeneralPreferencesFragment.a(sDMContext);
//            LayoutInflater.from(getContext()).inflate(R.layout.extra_toolintro_view, this);
//            ButterKnife.a(this, this);
//            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c2.ToolIntroView);
//            ImageView imageView = this.introIcon;
//            if (imageView != null) {
//                imageView.setImageDrawable(obtainStyledAttributes.getDrawable(1));
//                TextView textView = this.introTitle;
//                if (textView != null) {
//                    textView.setText(obtainStyledAttributes.getString(2));
//                    TextView textView2 = this.introDescription;
//                    if (textView2 != null) {
//                        textView2.setText(obtainStyledAttributes.getString(0));
//                        LottieAnimationView lottieAnimationView = this.workingAnimation;
//                        if (lottieAnimationView != null) {
//                            lottieAnimationView.setOnClickListener(new a(this));
//                            obtainStyledAttributes.recycle();
//                            TextView textView3 = this.emptyCaption;
//                            if (textView3 != null) {
//                                textView3.setText(getResources().getQuantityString(R.plurals.result_x_items, 0, new Object[]{0}));
//                                return;
//                            }
//                            i.b("emptyCaption");
//                            throw null;
//                        }
//                        i.b("workingAnimation");
//                        throw null;
//                    }
//                    i.b("introDescription");
//                    throw null;
//                }
//                i.b("introTitle");
//                throw null;
//            }
//            i.b("introIcon");
//            throw null;
//        }
//        i.a("context");
//        throw null;
//    }
//
//    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
//    public /* synthetic */ ToolIntroView(Context context, AttributeSet attributeSet, int i, int i2, f fVar) {
//        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
//    }
//
//    public final void a(Fragment fragment, b bVar) {
//        if (fragment == null) {
//            i.a("fragment");
//            throw null;
//        } else if (bVar != null) {
//            a.c a2 = n0.a.a.a(h);
//            a2.a("setState(fragment=" + fragment + ", state=" + bVar, new Object[0]);
//            if (this.f2288e != bVar) {
//                this.f2288e = bVar;
//                if (bVar == b.WORKING) {
//                    setVisibility(0);
//                    this.g = 0;
//                    ViewGroup viewGroup = this.introContainer;
//                    if (viewGroup != null) {
//                        viewGroup.setVisibility(8);
//                        ViewGroup viewGroup2 = this.emptyContainer;
//                        if (viewGroup2 != null) {
//                            viewGroup2.setVisibility(8);
//                            ViewGroup viewGroup3 = this.workingContainer;
//                            if (viewGroup3 != null) {
//                                viewGroup3.setVisibility(0);
//                                if (this.f) {
//                                    LottieAnimationView lottieAnimationView = this.workingAnimation;
//                                    if (lottieAnimationView != null) {
//                                        lottieAnimationView.setAnimation((int) R.raw.sd_maid_animation);
//                                        LottieAnimationView lottieAnimationView2 = this.workingAnimation;
//                                        if (lottieAnimationView2 != null) {
//                                            lottieAnimationView2.setRepeatCount(-1);
//                                            LottieAnimationView lottieAnimationView3 = this.workingAnimation;
//                                            if (lottieAnimationView3 != null) {
//                                                lottieAnimationView3.f();
//                                            } else {
//                                                i.b("workingAnimation");
//                                                throw null;
//                                            }
//                                        } else {
//                                            i.b("workingAnimation");
//                                            throw null;
//                                        }
//                                    } else {
//                                        i.b("workingAnimation");
//                                        throw null;
//                                    }
//                                } else {
//                                    LottieAnimationView lottieAnimationView4 = this.workingAnimation;
//                                    if (lottieAnimationView4 != null) {
//                                        lottieAnimationView4.e();
//                                        LottieAnimationView lottieAnimationView5 = this.workingAnimation;
//                                        if (lottieAnimationView5 != null) {
//                                            lottieAnimationView5.clearAnimation();
//                                        } else {
//                                            i.b("workingAnimation");
//                                            throw null;
//                                        }
//                                    } else {
//                                        i.b("workingAnimation");
//                                        throw null;
//                                    }
//                                }
//                            } else {
//                                i.b("workingContainer");
//                                throw null;
//                            }
//                        } else {
//                            i.b("emptyContainer");
//                            throw null;
//                        }
//                    } else {
//                        i.b("introContainer");
//                        throw null;
//                    }
//                } else {
//                    LottieAnimationView lottieAnimationView6 = this.workingAnimation;
//                    if (lottieAnimationView6 != null) {
//                        lottieAnimationView6.o = false;
//                        e0.a.a.f fVar = lottieAnimationView6.k;
//                        fVar.j.clear();
//                        fVar.g.cancel();
//                        lottieAnimationView6.d();
//                        ViewGroup viewGroup4 = this.workingContainer;
//                        if (viewGroup4 != null) {
//                            viewGroup4.setVisibility(8);
//                            if (bVar == b.INTRO) {
//                                setVisibility(0);
//                                ViewGroup viewGroup5 = this.emptyContainer;
//                                if (viewGroup5 != null) {
//                                    viewGroup5.setVisibility(8);
//                                    ViewGroup viewGroup6 = this.introContainer;
//                                    if (viewGroup6 != null) {
//                                        viewGroup6.setVisibility(0);
//                                    } else {
//                                        i.b("introContainer");
//                                        throw null;
//                                    }
//                                } else {
//                                    i.b("emptyContainer");
//                                    throw null;
//                                }
//                            } else if (bVar == b.NORESULTS) {
//                                setVisibility(0);
//                                ViewGroup viewGroup7 = this.introContainer;
//                                if (viewGroup7 != null) {
//                                    viewGroup7.setVisibility(8);
//                                    ViewGroup viewGroup8 = this.emptyContainer;
//                                    if (viewGroup8 != null) {
//                                        viewGroup8.setVisibility(0);
//                                    } else {
//                                        i.b("emptyContainer");
//                                        throw null;
//                                    }
//                                } else {
//                                    i.b("introContainer");
//                                    throw null;
//                                }
//                            } else if (bVar == b.GONE) {
//                                setVisibility(8);
//                                ViewGroup viewGroup9 = this.introContainer;
//                                if (viewGroup9 != null) {
//                                    viewGroup9.setVisibility(8);
//                                    ViewGroup viewGroup10 = this.emptyContainer;
//                                    if (viewGroup10 != null) {
//                                        viewGroup10.setVisibility(8);
//                                    } else {
//                                        i.b("emptyContainer");
//                                        throw null;
//                                    }
//                                } else {
//                                    i.b("introContainer");
//                                    throw null;
//                                }
//                            }
//                        } else {
//                            i.b("workingContainer");
//                            throw null;
//                        }
//                    } else {
//                        i.b("workingAnimation");
//                        throw null;
//                    }
//                }
//            }
//        } else {
//            i.a("state");
//            throw null;
//        }
//    }
//
//    public final TextView getEmptyCaption() {
//        TextView textView = this.emptyCaption;
//        if (textView != null) {
//            return textView;
//        }
//        i.b("emptyCaption");
//        throw null;
//    }
//
//    public final ViewGroup getEmptyContainer() {
//        ViewGroup viewGroup = this.emptyContainer;
//        if (viewGroup != null) {
//            return viewGroup;
//        }
//        i.b("emptyContainer");
//        throw null;
//    }
//
//    public final ViewGroup getIntroContainer() {
//        ViewGroup viewGroup = this.introContainer;
//        if (viewGroup != null) {
//            return viewGroup;
//        }
//        i.b("introContainer");
//        throw null;
//    }
//
//    public final TextView getIntroDescription() {
//        TextView textView = this.introDescription;
//        if (textView != null) {
//            return textView;
//        }
//        i.b("introDescription");
//        throw null;
//    }
//
//    public final ImageView getIntroIcon() {
//        ImageView imageView = this.introIcon;
//        if (imageView != null) {
//            return imageView;
//        }
//        i.b("introIcon");
//        throw null;
//    }
//
//    public final TextView getIntroTitle() {
//        TextView textView = this.introTitle;
//        if (textView != null) {
//            return textView;
//        }
//        i.b("introTitle");
//        throw null;
//    }
//
//    public final b getState() {
//        return this.f2288e;
//    }
//
//    public final LottieAnimationView getWorkingAnimation() {
//        LottieAnimationView lottieAnimationView = this.workingAnimation;
//        if (lottieAnimationView != null) {
//            return lottieAnimationView;
//        }
//        i.b("workingAnimation");
//        throw null;
//    }
//
//    public final ViewGroup getWorkingContainer() {
//        ViewGroup viewGroup = this.workingContainer;
//        if (viewGroup != null) {
//            return viewGroup;
//        }
//        i.b("workingContainer");
//        throw null;
//    }
//
//    public final void setEmptyCaption(TextView textView) {
//        if (textView != null) {
//            this.emptyCaption = textView;
//        } else {
//            i.a("<set-?>");
//            throw null;
//        }
//    }
//
//    public final void setEmptyContainer(ViewGroup viewGroup) {
//        if (viewGroup != null) {
//            this.emptyContainer = viewGroup;
//        } else {
//            i.a("<set-?>");
//            throw null;
//        }
//    }
//
//    public final void setIntroContainer(ViewGroup viewGroup) {
//        if (viewGroup != null) {
//            this.introContainer = viewGroup;
//        } else {
//            i.a("<set-?>");
//            throw null;
//        }
//    }
//
//    public final void setIntroDescription(int i) {
//        TextView textView = this.introDescription;
//        if (textView != null) {
//            textView.setText(i);
//        } else {
//            i.b("introDescription");
//            throw null;
//        }
//    }
//
//    public final void setIntroDescription(TextView textView) {
//        if (textView != null) {
//            this.introDescription = textView;
//        } else {
//            i.a("<set-?>");
//            throw null;
//        }
//    }
//
//    public final void setIntroDescription(String str) {
//        if (str != null) {
//            TextView textView = this.introDescription;
//            if (textView != null) {
//                textView.setText(str);
//            } else {
//                i.b("introDescription");
//                throw null;
//            }
//        } else {
//            i.a("description");
//            throw null;
//        }
//    }
//
//    public final void setIntroIcon(int i) {
//        ImageView imageView = this.introIcon;
//        if (imageView != null) {
//            imageView.setImageResource(i);
//        } else {
//            i.b("introIcon");
//            throw null;
//        }
//    }
//
//    public final void setIntroIcon(ImageView imageView) {
//        if (imageView != null) {
//            this.introIcon = imageView;
//        } else {
//            i.a("<set-?>");
//            throw null;
//        }
//    }
//
//    public final void setIntroTitle(int i) {
//        TextView textView = this.introTitle;
//        if (textView != null) {
//            textView.setText(i);
//        } else {
//            i.b("introTitle");
//            throw null;
//        }
//    }
//
//    public final void setIntroTitle(TextView textView) {
//        if (textView != null) {
//            this.introTitle = textView;
//        } else {
//            i.a("<set-?>");
//            throw null;
//        }
//    }
//
//    public final void setWorkingAnimation(LottieAnimationView lottieAnimationView) {
//        if (lottieAnimationView != null) {
//            this.workingAnimation = lottieAnimationView;
//        } else {
//            i.a("<set-?>");
//            throw null;
//        }
//    }
//
//    public final void setWorkingContainer(ViewGroup viewGroup) {
//        if (viewGroup != null) {
//            this.workingContainer = viewGroup;
//        } else {
//            i.a("<set-?>");
//            throw null;
//        }
//    }
//}